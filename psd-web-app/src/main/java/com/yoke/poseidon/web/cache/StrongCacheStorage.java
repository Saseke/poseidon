package com.yoke.poseidon.web.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 强引用
 *
 * @Author Yoke
 * @Date 2018/10/24 下午10:13
 */
public class StrongCacheStorage
		implements CacheStorageWithGetSize, ConcurrentCacheStorage {

	private final Map<Object, Object> map = new ConcurrentHashMap<>();

	@Override
	public int getSize() {
		return map.size();
	}

	@Override
	public boolean isConcurrent() {
		return true;
	}

	@Override
	public Object get(Object key) {
		return map.get(key);
	}

	@Override
	public void put(Object key, Object value) {
		map.put(key, value);
	}

	@Override
	public void remove(Object key) {
		map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
	}

}
