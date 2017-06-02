package com.example.common;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

public class WeixinProperties {

	private static String domain ;// 域名地址//暂时不用
	
	public static String appid ;// 应用ID

	public static String app_secert;// 应用秘钥

	public static String token;

	public static String aeskey;// EncodingAESKey

	public static String redirect_uri;// 授权重定向链接

	// 支付使用
	public static String cert_path ;
	public static String mch_id;//微信支付商户号
	public static String mch_api_key;//微信支付 API 安全秘钥  key用来校验微信支付返回后的通知签名的有效性
	public static String cert_password;
	public static String pay_callbackurl;//微信支付跳转地址地址;
	// 分享描述
	public static String shop_desc;
	
	//已发货未确认-->收货确认 间隔时间，单位（天）
	public static Integer distancedays;
	
	//线上交易记录核销     平台运营费  百分比(%)
//	public  static double cost_precent;
	
	public static String ebusinessid; // 电商ID

	public static String ebusinesskey; // 电商加密私钥

	public static String ebusinessurl; // 请求url
	
	
	//============fastDFS相关参数 
//	public static  String tracker_server = "123.56.237.72:22122";//fastDFS客户端连接使用
	public static  String tracker_server = "218.247.157.247:22122";//fastDFS客户端连接使用
//	public static  String tracker_server = "123.206.187.227:22122";//fastDFS客户端连接使用
//	public static  String tracker_server = "192.168.80.131:22122";//fastDFS客户端连接使用
	
	public static String img_url ="123.56.237.72";//#图片服服器的ip
	
	public static Integer connect_timeout = 60;//fastDFS
	
	public static Integer network_timeout = 60;//fastDFS
	
	public static String charset;//fastDFS字符集
	
	public static Integer tracker_http_port = 8080;//http端口
	
	public static Boolean anti_steal_token = false;//开启token令牌
	
	public static String secret_key;//密钥
	



	public String getDomain() {
		return domain;
	}


	public void setDomain(String domain) {
		this.domain = domain;
	}


	public String getAppid() {
		return appid;
	}


	public void setAppid(String appid) {
		this.appid = appid;
	}


	public String getApp_secert() {
		return app_secert;
	}


	public void setApp_secert(String app_secert) {
		this.app_secert = app_secert;
	}


	public String getToken() {
		return token;
	}


	public void setToken(String token) {
		this.token = token;
	}


	public String getAeskey() {
		return aeskey;
	}


	public void setAeskey(String aeskey) {
		this.aeskey = aeskey;
	}


	public String getRedirect_uri() {
		return redirect_uri;
	}


	public void setRedirect_uri(String redirect_uri) {
		this.redirect_uri = redirect_uri;
	}


	public String getCert_path() {
		return cert_path;
	}


	public void setCert_path(String cert_path) {
		this.cert_path = cert_path;
	}


	public String getMch_id() {
		return mch_id;
	}


	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}


	public String getMch_api_key() {
		return mch_api_key;
	}


	public void setMch_api_key(String mch_api_key) {
		this.mch_api_key = mch_api_key;
	}


	public String getCert_password() {
		return cert_password;
	}


	public void setCert_password(String cert_password) {
		this.cert_password = cert_password;
	}


	public String getPay_callbackurl() {
		return pay_callbackurl;
	}


	public void setPay_callbackurl(String pay_callbackurl) {
		this.pay_callbackurl = pay_callbackurl;
	}


	public String getShop_desc() {
		return shop_desc;
	}


	public void setShop_desc(String shop_desc) {
		this.shop_desc = shop_desc;
	}


	public Integer getDistancedays() {
		return distancedays;
	}


	public void setDistancedays(Integer distancedays) {
		this.distancedays = distancedays;
	}


	public String getEbusinessid() {
		return ebusinessid;
	}


	public void setEbusinessid(String ebusinessid) {
		this.ebusinessid = ebusinessid;
	}


	public String getEbusinesskey() {
		return ebusinesskey;
	}


	public void setEbusinesskey(String ebusinesskey) {
		this.ebusinesskey = ebusinesskey;
	}


	public String getEbusinessurl() {
		return ebusinessurl;
	}


	public void setEbusinessurl(String ebusinessurl) {
		this.ebusinessurl = ebusinessurl;
	}


	public String getTracker_server() {
		return tracker_server;
	}


	public void setTracker_server(String tracker_server) {
		this.tracker_server = tracker_server;
	}


	public String getImg_url() {
		return img_url;
	}


	public void setImg_url(String img_url) {
		this.img_url = img_url;
	}


	public  Integer getConnect_timeout() {
		return connect_timeout;
	}


	public  void setConnect_timeout(Integer connect_timeout) {
		this.connect_timeout = connect_timeout;
	}


	public  Integer getNetwork_timeout() {
		return network_timeout;
	}


	public  void setNetwork_timeout(Integer network_timeout) {
		this.network_timeout = network_timeout;
	}


	public  String getCharset() {
		return charset;
	}


	public  void setCharset(String charset) {
		this.charset = charset;
	}


	public  Integer getTracker_http_port() {
		return tracker_http_port;
	}


	public  void setTracker_http_port(Integer tracker_http_port) {
		this.tracker_http_port = tracker_http_port;
	}


	public  Boolean getAnti_steal_token() {
		return anti_steal_token;
	}


	public  void setAnti_steal_token(Boolean anti_steal_token) {
		this.anti_steal_token = anti_steal_token;
	}


	public  String getSecret_key() {
		return secret_key;
	}


	public  void setSecret_key(String secret_key) {
		this.secret_key = secret_key;
	}

	
}

























