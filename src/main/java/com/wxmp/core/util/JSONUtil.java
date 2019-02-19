
package com.wxmp.core.util;

import com.alibaba.fastjson.JSONObject;

import java.io.UnsupportedEncodingException;

public class JSONUtil {

	public static String renderString(JSONObject jsonObj){
		try {
			return new String(jsonObj.toString().getBytes("UTF-8"),"ISO8859-1");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return "";
	}
}
