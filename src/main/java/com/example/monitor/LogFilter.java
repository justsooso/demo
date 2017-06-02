package com.example.monitor;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import eu.bitwalker.useragentutils.UserAgent;

@Component
public class LogFilter implements Filter {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	private boolean stopMonitor = false;
	@Autowired
	Collector collector;
	@Autowired
	CollectorRegister register;
	@Autowired
	TraceLogger traceLog;
	final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
	private String excludeUrl = "/lib/**,/static/**";
	private String[] urls = null;
	AntPathMatcher matcher = new AntPathMatcher();

	public LogFilter() {
		this.logger.info(" init!");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		if (!this.stopMonitor && !this.matched(httpRequest.getRequestURI())) {
			StringBuffer sb = new StringBuffer();
			RequestData req = new RequestData(httpRequest);
			sb.append("-");
			sb.append("-");
			sb.append(UUID.randomUUID());
			String uuid = sb.toString();
			String userAgentStr = httpRequest.getHeader("User-Agent");
			UserAgent userAgent = UserAgent.parseUserAgentString(userAgentStr);
			userAgent.toString();
			this.traceLog.init(uuid);
			req.setId(uuid);
			req.setUserAgentShort(userAgent.toString());
			req.setUserAgentWhole(userAgentStr);

			req.setThread(Thread.currentThread());
			Map parameterMap = httpRequest.getParameterMap();
			HashMap cloneMap = new HashMap();
			cloneMap.putAll(parameterMap);
			if (cloneMap.size() > 0) {
				req.setParameterMap(cloneMap);
			}

			this.collector.collect(req);
			ResponseData resp = new ResponseData();
			CollectDataHolder.set(resp);

			try {
				resp.setId(uuid);
				chain.doFilter(request, response);
				ResponseData e = CollectDataHolder.get();
				if (e != null) {
					resp = e;
				}

				this.traceLog.log("");
			} catch (Exception arg24) {
				RequestTrace RequestTrace = this.traceLog.getRequestTrace();
				if (RequestTrace != null) {
					MDC.put("saas.traceid", RequestTrace.getLogFileTraceId());
				}

				this.logger.error(arg24.getLocalizedMessage());
				this.traceLog.log("error:" + arg24.getLocalizedMessage());
				resp.setSucceed(false);
				throw arg24;
			} finally {
				if (resp != null) {
					try {
						HttpServletResponse ex = (HttpServletResponse) response;
						ex.setHeader("traceid", uuid);
						resp.setTimestamp(System.currentTimeMillis());
						RequestTrace RequestTrace1 = this.traceLog.getRequestTrace();
						resp.getDataMap().put("traceLog", RequestTrace1);
						this.collector.collect(resp);
						CollectDataHolder.clear();
						this.traceLog.destory();
					} catch (Exception arg22) {
						this.logger.error("error", arg22);
					}
				}

			}

		} else {
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig filterConfig) throws ServletException {
		this.register.regist(this.collector);
	}

	public void destroy() {
		this.collector.clear();
		this.register.clear();
	}

	public boolean matched(String uri) {
		if (this.urls == null && this.excludeUrl != null) {
			synchronized (this) {
				this.urls = this.excludeUrl.split(",");
			}
		}

		if (this.urls != null) {
			String[] arg4 = this.urls;
			int arg3 = this.urls.length;

			for (int arg2 = 0; arg2 < arg3; ++arg2) {
				String url = arg4[arg2];
				if (this.matcher.match(url.trim(), uri)) {
					return true;
				}
			}
		}

		return false;
	}

	public Collector getCollector() {
		return this.collector;
	}

	public void setCollector(Collector collector) {
		this.collector = collector;
	}

	public CollectorRegister getRegister() {
		return this.register;
	}

	public void setRegister(CollectorRegister register) {
		this.register = register;
	}

	public boolean isStopMonitor() {
		return this.stopMonitor;
	}

	public void setStopMonitor(boolean stopMonitor) {
		this.stopMonitor = stopMonitor;
	}
}