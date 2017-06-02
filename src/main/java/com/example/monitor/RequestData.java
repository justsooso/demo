package com.example.monitor;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;

public class RequestData extends CollectData {
	String id;
	String url;
	String serverhost;
	String clientip;
	String uri;
	long timestamp;
	String userAgentShort;
	String userAgentWhole;
	long lastPingSpent;
	String productVersion;
	@JsonIgnore
	transient Thread thread;
	Map parameterMap;

	public RequestData() {
		super(1);
	}

	public RequestData(HttpServletRequest httpRequest) {
		this();
		this.setUrl(httpRequest.getRequestURL().toString());
		this.setClientip(httpRequest.getRemoteHost());
		this.setServerhost(httpRequest.getServerName());
		this.setUri(httpRequest.getRequestURI());
		this.setTimestamp(System.currentTimeMillis());
		String lastPingSpent = httpRequest.getParameter("lastPingSpent");
		if (lastPingSpent != null && lastPingSpent.length() > 0) {
			try {
				Long spent = Long.valueOf(lastPingSpent);
				this.setLastPingSpent(spent.longValue());
			} catch (NumberFormatException arg3) {
				;
			}
		}

	}

	public String getId() {
		return this.id;
	}

	public Map getParameterMap() {
		return this.parameterMap;
	}

	public void setParameterMap(Map parameterMap) {
		this.parameterMap = parameterMap;
	}

	public Thread getThread() {
		return this.thread;
	}

	public void setThread(Thread thread) {
		this.thread = thread;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getServerhost() {
		return this.serverhost;
	}

	public void setServerhost(String serverhost) {
		this.serverhost = serverhost;
	}

	public String getClientip() {
		return this.clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getUserAgentShort() {
		return this.userAgentShort;
	}

	public void setUserAgentShort(String userAgentShort) {
		this.userAgentShort = userAgentShort;
	}

	public String getUserAgentWhole() {
		return this.userAgentWhole;
	}

	public void setUserAgentWhole(String userAgentWhole) {
		this.userAgentWhole = userAgentWhole;
	}

	public String toJson() {
		ObjectMapper om = new ObjectMapper();
		String json = "";

		try {
			json = om.writeValueAsString(this);
		} catch (JsonProcessingException arg3) {
			arg3.printStackTrace();
		}

		return json;
	}

	public static void main(String[] args) {
		RequestData r = new RequestData();
		System.out.println(r.toJson());
	}

	public long getLastPingSpent() {
		return this.lastPingSpent;
	}

	public void setLastPingSpent(long lastPingSpent) {
		this.lastPingSpent = lastPingSpent;
	}

	public String getProductVersion() {
		return this.productVersion;
	}

	public void setProductVersion(String productVersion) {
		this.productVersion = productVersion;
	}
}