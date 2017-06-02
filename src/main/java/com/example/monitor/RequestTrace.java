package com.example.monitor;

import java.util.Stack;

public class RequestTrace {
	private long firstTime;
	private String uuid;
	private String logFileTraceId;
	private Stack<TrackStack> stack = new Stack();

	public Stack<TrackStack> getStack() {
		return this.stack;
	}

	public void setStack(Stack<TrackStack> stack) {
		this.stack = stack;
	}

	public long getFirstTime() {
		return this.firstTime;
	}

	public void setFirstTime(long firstTime) {
		this.firstTime = firstTime;
	}

	public String getUuid() {
		return this.uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getLogFileTraceId() {
		return this.logFileTraceId;
	}

	public void setLogFileTraceId(String logFileTraceId) {
		this.logFileTraceId = logFileTraceId;
	}
}