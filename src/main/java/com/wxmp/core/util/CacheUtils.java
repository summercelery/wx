package com.wxmp.core.util;

import com.wxmp.core.spring.SpringContextHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
public class CacheUtils {

	private static RedisTemplate redisTemplate =  SpringContextHolder.getBean(RedisTemplate.class);

	private static final String WX_CACHE = "wxCache";


	/**
	 * 获取WX_CACHE缓存
	 * @param key
	 * @return
	 */
	public static Object get(String key) {
		return get(WX_CACHE, key);
	}

	/**
	 * 写入WX_CACHE缓存
	 * @param key
	 * @return
	 */
	public static void put(String key, Object value) {
		put(WX_CACHE, key, value);
	}

	/**
	 * 从WX_CACHE缓存中移除
	 * @param key
	 * @return
	 */
	public static void remove(String key) {
		remove(WX_CACHE, key);
	}

	/**
	 * 获取缓存
	 * @param cacheName
	 * @param key
	 * @return
	 */
	public static Object get(String cacheName, String key) {
		return redisTemplate.opsForValue().get(key);
	}

	/**
	 * 写入缓存
	 * @param cacheName
	 * @param key
	 * @param value
	 */
	public static void put(String cacheName, String key, Object value) {
		redisTemplate.opsForValue().set(key,value);
	}

	/**
	 * 从缓存中移除
	 * @param cacheName
	 * @param key
	 */
	public static void remove(String cacheName, String key) {
		redisTemplate.delete(key);
	}
}
