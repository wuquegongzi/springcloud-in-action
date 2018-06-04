package com.iwufang.common.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

/**
 * 
 * @ClassName: GsonUtils
 * @Description: Gson工具类
 * @author leon
 * @date 2017年5月23日 下午8:29:08
 * 
 */
public class GsonUtils {
	private static Gson gson = null;
	static {
		if (gson == null) {
			gson = new Gson();
//					new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss")
//					.create();
		}
	}

	private GsonUtils() {
	}

	/**
	 * 转成json
	 * 
	 * @param object
	 * @return
	 */
	public static String GsonString(Object object) {
		String gsonString = null;
		if (gson != null) {
			gsonString = gson.toJson(object);
		}
		return gsonString;
	}

	/**
	 * 转成bean
	 * 
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> T GsonToBean(String gsonString, Class<T> cls) {
		T t = null;
		if (gson != null) {
			t = gson.fromJson(gsonString, cls);
		}
		return t;
	}

	/**
	 * 转成list
	 * 有些情况下转化后的List后续使用会报转换错误
	 * @param gsonString
	 * @param cls
	 * @return
	 */
	public static <T> List<T> GsonToList(String gsonString, Class<T> cls) {
		List<T> list = null;
		if (gson != null) {
			list = gson.fromJson(gsonString, new TypeToken<List<T>>() {
			}.getType());
		}
		return list;
	}

	/**
	 * 
	* @Title: fromJsonList 
	* @Description: 转List
	* @param @param json
	* @param @param cls
	* @param @return    设定文件 
	* @return ArrayList<T>    返回类型 
	* @throws
	 */
	public static <T> ArrayList<T> fromJsonList(String json, Class<T> cls) {
		ArrayList<T> mList = new ArrayList<T>();
		JsonArray array = new JsonParser().parse(json).getAsJsonArray();
		for (final JsonElement elem : array) {
			mList.add(gson.fromJson(elem, cls));
		}
		return mList;
	}


	/**
	 * 转成map的
	 * 
	 * @param gsonString
	 * @return
	 */
	public static <T> Map<String, T> GsonToMaps(String gsonString) {
		Map<String, T> map = null;
		if (gson != null) {
			map = gson.fromJson(gsonString, new TypeToken<Map<String, T>>() {
			}.getType());
		}
		return map;
	}

	/**
	 * 
	 * @Title: MapsToGson
	 * @Description: map 转json
	 * @param @param map
	 * @param @return 设定文件
	 * @return String 返回类型
	 * @throws
	 */
	public static String MapsToGson(Map<?,?> map) {
		Gson gson2 = new GsonBuilder().enableComplexMapKeySerialization()
				.create();
		return gson2.toJson(map);
	}
}
