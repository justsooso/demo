package com.example.monitor;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.stereotype.Component;

@Component
public class TraceLogCache {
	int queneMaxSize = 100;
	Map<String, RequestTrace> cache = new HashMap();
	ConcurrentLinkedQueue<String> uuids = new ConcurrentLinkedQueue();

	public void clear() {
		this.cache.clear();
		this.uuids.clear();
	}

	public void put(String uuid, RequestTrace RequestTrace) {
		if (this.uuids.size() >= this.queneMaxSize) {
			String headUuid = (String) this.uuids.poll();
			RequestTrace trace = (RequestTrace) this.cache.remove(headUuid);
			System.out.println("remove trace:" + (new Date(trace.getFirstTime())).toString() + " " + trace.getStack());
		}

		this.uuids.offer(uuid);
		this.cache.put(uuid, RequestTrace);
	}

	public RequestTrace getTrace(String traceid) {
		return (RequestTrace) this.cache.get(traceid);
	}

	public int getQueneMaxSize() {
		return this.queneMaxSize;
	}

	public void setQueneMaxSize(int queneMaxSize) {
		this.queneMaxSize = queneMaxSize;
	}

	public Map<String, RequestTrace> getCache() {
		return this.cache;
	}

	public void setCache(Map<String, RequestTrace> cache) {
		this.cache = cache;
	}

	public ConcurrentLinkedQueue<String> getUuids() {
		return this.uuids;
	}

	public void setUuids(ConcurrentLinkedQueue<String> uuids) {
		this.uuids = uuids;
	}
}