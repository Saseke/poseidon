package com.yoke.poseidon.web.cache;

/**
 * @Author Yoke
 * @Date 2018/10/24 下午10:11
 */
public interface ConcurrentCacheStorage extends CacheStorage {

	boolean isConcurrent();

}
