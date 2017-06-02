package com.example.monitor;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.LinkedList;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QueueCollector implements Collector {
	final Logger logger = LoggerFactory.getLogger(this.getClass());
	ConcurrentLinkedQueue<CollectData> cdata = new ConcurrentLinkedQueue();
	long lastDumpTime;
	ObjectMapper om = new ObjectMapper();

	public void clear() {
		this.cdata.clear();
	}

	public void collect(CollectData data) {
		this.cdata.add(data);
	}

	public String dump(int size) {
		long start = System.currentTimeMillis();
		LinkedList cdata_tmp = new LinkedList();
		int size1 = this.size();
		int size3 = 0;

		while (!this.cdata.isEmpty()) {
			CollectData json = (CollectData) this.cdata.poll();
			if (json != null) {
				cdata_tmp.add(json);
				++size3;
				if (size3 >= size) {
					break;
				}
			}
		}

		String arg9 = null;

		try {
			arg9 = this.om.writeValueAsString(cdata_tmp);
		} catch (JsonProcessingException arg8) {
			arg8.printStackTrace();
		}

		this.logger.info("monitor dump  before size:" + size1 + " tmp size:" + size3 + "  after size :" + this.size()
				+ " dump spent：" + (System.currentTimeMillis() - start));
		this.lastDumpTime = System.currentTimeMillis();
		return arg9;
	}

	public int size() {
		return this.cdata.size();
	}

	public static void main(String[] args) {
		final QueueCollector json = new QueueCollector();
		Timer timer = new Timer();


		try {
			Thread.sleep(5000L);
		} catch (InterruptedException arg3) {
			arg3.printStackTrace();
		}

		timer.scheduleAtFixedRate(new TimerTask() {
			public void run() {
				long time = System.currentTimeMillis();
				if (json.size() > 10000) {
					json.dump(10000);
				} else if (time - json.lastDumpTime >= 1000L) {
					System.out.println("======================================================================");
					json.dump(10000);
				}

			}
		}, 1000L, 100L);
	}

	public long lastDumpTime() {
		return this.lastDumpTime;
	}
}