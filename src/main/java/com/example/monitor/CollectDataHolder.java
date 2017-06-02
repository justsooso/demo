package com.example.monitor;


public class CollectDataHolder {
	static ThreadLocal<ResponseData> responseData = new ThreadLocal();

	public static void set(ResponseData data) {
		responseData.set(data);
	}

	public static ResponseData get() {
		return (ResponseData) responseData.get();
	}

	public static void clear() {
		responseData.remove();
	}
}