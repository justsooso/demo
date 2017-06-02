package com.example.monitor;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TrackStack {
	private String title;
	private long timestamp;
	private String classname;
	private String methodname;
	private String linenumber;
	@JsonIgnore
	private StackTraceElement trace;
	@JsonIgnore
	private TrackStack before;
	private long spent;

	public TrackStack(TrackStack before) {
		this.before = before;
	}

	public String getClassname() {
		return this.classname;
	}

	public void setClassname(String classname) {
		this.classname = classname;
	}

	public String getMethodname() {
		return this.methodname;
	}

	public void setMethodname(String methodname) {
		this.methodname = methodname;
	}

	public String getLinenumber() {
		return this.linenumber;
	}

	public void setLinenumber(String linenumber) {
		this.linenumber = linenumber;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
		if (this.before != null) {
			this.spent = this.timestamp - this.before.timestamp;
		}

	}

	public StackTraceElement getTrace() {
		return this.trace;
	}

	public void setTrace(StackTraceElement trace) {
		this.trace = trace;
	}

	public TrackStack getBefore() {
		return this.before;
	}

	public void setBefore(TrackStack before) {
		this.before = before;
	}

	public long getSpent() {
		return this.spent;
	}

	public void setSpent(long spent) {
		this.spent = spent;
	}

	public String toString() {
		return String.format("title[%s] timestamp[%s] spent[%s]" + this.trace.toString(),
				new Object[] { this.title, Long.valueOf(this.timestamp), Long.valueOf(this.spent) });
	}
}