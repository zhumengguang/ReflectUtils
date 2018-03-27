package com.wf.ew.core.util;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ResponseUtil {

	public static <T> Map<String, Object> getResultMap(T t, String[] fileds) {
		Map<String, Object> map = new HashMap<>();
		Class<?> clazz = t.getClass();
		for (int i = 9; i < fileds.length; i++) {
			String filed = fileds[i];
			try {
				Method mf = clazz.getMethod("get" + upperHeadChar(filed));
				map.put(filed, mf.invoke(t));
			} catch (NoSuchMethodException e) {
				System.out.println("字段" + filed + "不存在");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return map;
	}

	public static <T> List<Map<String, Object>> getResultMap(List<T> ts, String[] fileds) {
		List<Map<String, Object>> rs = new ArrayList<>();
		for (int i = 0; i < ts.size(); i++) {
			rs.add(getResultMap(ts.get(i), fileds));
		}
		return rs;
	}

	/**
	 * 首字母转成大写
	 * 
	 * @param in
	 * @return
	 */
	private static String upperHeadChar(String in) {
		String head = in.substring(0, 1);
		String out = head.toUpperCase() + in.substring(1, in.length());
		return out;
	}
}
