package com.yoke.poseidon.web.cache;

/**
 * @Author Yoke
 * @Date 2018/10/24 下午10:10
 */
public interface CacheStorage {

	public Object get(Object key);

	public void put(Object key, Object value);

	public void remove(Object key);

	public void clear();

}
