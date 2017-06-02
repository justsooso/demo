package com.example.monitor;


public interface Collector {
	void clear();

	void collect(CollectData arg0);

	String dump(int arg0);

	int size();

	long lastDumpTime();
}