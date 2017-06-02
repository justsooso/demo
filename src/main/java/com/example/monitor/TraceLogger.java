package com.example.monitor;

import java.util.Iterator;
import java.util.Stack;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Component
public class TraceLogger {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	boolean openTrace = true;
	static int count = 0;
	
	@Autowired
	TraceLogCache traceLogCache;

	public void init(String traceId) {
		if (this.openTrace) {
			TraceHolder.clear();
			RequestTrace trace = new RequestTrace();
			trace.setUuid(traceId);
			trace.setFirstTime(System.currentTimeMillis());
			TraceHolder.set(trace);
		}
	}

	public void destory() {
		TraceHolder.clear();
	}

	public void log(String name) {
		if (this.openTrace) {
			RequestTrace trace = TraceHolder.get();
			if (trace != null) {
				byte index = 3;
				Stack stack = trace.getStack();
				TrackStack before = null;
				if (stack.size() > 0) {
					before = (TrackStack) stack.lastElement();
				}

				TrackStack item = new TrackStack(before);
				long currentTimeMillis = System.currentTimeMillis();
				if (before == null) {
					long stackTrace = currentTimeMillis - trace.getFirstTime();
					item.setSpent(stackTrace);
				}

				item.setTimestamp(currentTimeMillis);
				item.setTitle(name);
				StackTraceElement stackTrace1 = this.getStackTrace(index);
				if (stackTrace1 != null) {
					item.setTrace(stackTrace1);
					item.setClassname(stackTrace1.getClassName());
					item.setMethodname(stackTrace1.getMethodName());
					item.setLinenumber(String.valueOf(stackTrace1.getLineNumber()));
				}

				stack.push(item);
				this.traceLogCache.put(trace.getUuid(), trace);
			}

		}
	}

	public void log() {
		this.log("");
	}

	private StackTraceElement getStackTrace(int index) {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return index < stackTrace.length ? stackTrace[index] : null;
	}

	private static int get() {
		return ++count;
	}

	public static void main(String[] args) {
		final TraceLogger logger = new TraceLogger();
		final byte threadSize = 10;
		ThreadPoolExecutor pool = (ThreadPoolExecutor) Executors.newFixedThreadPool(threadSize);

		int om;
		for (om = 0; om < 5; ++om) {
			pool.execute(new Runnable() {
				public void run() {
					logger.traceLogCache = new TraceLogCache();
					logger.init("" + ++TraceLogger.count);

					for (int i = 0; i < threadSize; ++i) {
						try {
							Thread.sleep((long) i);
						} catch (InterruptedException arg2) {
							arg2.printStackTrace();
						}

						logger.log("11111111111" + i);
					}

				}
			});
		}

		for (om = 0; om < 5; ++om) {
			pool.execute(new Runnable() {
				public void run() {
					logger.traceLogCache = new TraceLogCache();
					logger.init("" + ++TraceLogger.count);

					for (int i = 0; i < threadSize; ++i) {
						try {
							Thread.sleep((long) i);
						} catch (InterruptedException arg2) {
							arg2.printStackTrace();
						}

						logger.log("11111111111" + i);
					}

				}
			});
		}

		try {
			Thread.sleep(5000L);
		} catch (InterruptedException arg12) {
			arg12.printStackTrace();
		}

		ObjectMapper arg13 = new ObjectMapper();

		for (int i = 1; i <= threadSize; ++i) {
			System.out.println("================" + i + "================");
			TraceLogCache traceLogCache2 = logger.traceLogCache;
			RequestTrace trace = traceLogCache2.getTrace("" + i);
			Stack stack = trace.getStack();
			Iterator arg9 = stack.iterator();

			while (arg9.hasNext()) {
				TrackStack trackStack = (TrackStack) arg9.next();

				try {
					arg13.writeValueAsString(trackStack);
					System.out.println(trackStack.toString());
				} catch (JsonProcessingException arg11) {
					arg11.printStackTrace();
				}
			}
		}

	}

	public boolean isOpenTrace() {
		return this.openTrace;
	}

	public void setOpenTrace(boolean openTrace) {
		this.openTrace = openTrace;
	}

	public String getTraceId() {
		String traceId = null;
		RequestTrace RequestTrace = TraceHolder.get();
		if (RequestTrace != null) {
			traceId = RequestTrace.getUuid();
		}

		return traceId;
	}

	public RequestTrace getRequestTrace() {
		return TraceHolder.get();
	}
}