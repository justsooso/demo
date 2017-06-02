package com.example.monitor;

public class TraceHolder {
	
	static ThreadLocal<RequestTrace> holder = new ThreadLocal();

	public static void clear() {
		holder.remove();
	}

	public static void set(RequestTrace trace) {
		holder.set(trace);
	}

	public static RequestTrace get() {
		return (RequestTrace) holder.get();
	}

}
