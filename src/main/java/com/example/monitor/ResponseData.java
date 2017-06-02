package com.example.monitor;

import java.util.HashMap;
import java.util.Map;

public class ResponseData extends CollectData{
	String sessionid;
	String userid;
	String uri;
	Map<String, Object> dataMap = new HashMap();
	String id;
	long timestamp;
	boolean succeed = true;

	public ResponseData() {
		super(2);
	}

	public boolean isSucceed() {
		return this.succeed;
	}

	public String getUri() {
		return this.uri;
	}

	public void setUri(String uri) {
		this.uri = uri;
	}

	public void setSucceed(boolean succeed) {
		this.succeed = succeed;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public long getTimestamp() {
		return this.timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getSessionid() {
		return this.sessionid;
	}

	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}

	public String getUserid() {
		return this.userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Map<String, Object> getDataMap() {
		return this.dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}
}