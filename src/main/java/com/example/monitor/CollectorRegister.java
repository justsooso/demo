package com.example.monitor;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.springframework.stereotype.Component;

@Component
public class CollectorRegister {
	Set<Collector> collectors = new HashSet();

	public void regist(Collector collector) {
		this.collectors.add(collector);
	}

	public void remove(Collector collector) {
		this.collectors.remove(collector);
	}

	public void clear() {
		this.collectors.clear();
	}

	public Iterator<Collector> iterator() {
		return this.collectors.iterator();
	}
}