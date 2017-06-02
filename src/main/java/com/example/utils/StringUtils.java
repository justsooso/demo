package com.example.utils;

public class StringUtils {
	
	public static String removeRequestParam(String beforeUrl, String paramname){
		if(beforeUrl.contains(paramname)){
			int index = beforeUrl.indexOf("&", beforeUrl.indexOf(paramname));
			if(index==-1){
				beforeUrl = beforeUrl.substring(0, beforeUrl.indexOf(paramname)-1);
			}else{
				beforeUrl = beforeUrl.replace(beforeUrl.substring(beforeUrl.indexOf(paramname)-1, index), "");
				if(!beforeUrl.contains("?")){
					beforeUrl = beforeUrl.replaceFirst("&", "?");
				}
			}
		}
		return beforeUrl;
	}

}
