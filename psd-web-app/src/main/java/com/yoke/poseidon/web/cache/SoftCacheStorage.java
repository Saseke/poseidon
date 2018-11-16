package com.yoke.poseidon.web.cache;

import freemarker.template.utility.UndeclaredThrowableException;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 软引用,{@link SoftReference}常常和一个引用队列{@link ReferenceQueue}一起使用
 *
 * @Author Yoke
 * @Date 2018/10/24 下午10:38
 */
public class SoftCacheStorage implements CacheStorageWithGetSize, ConcurrentCacheStorage {

	private static final Method atomicRemove = getAtomicRemoveMethod();

	private final ReferenceQueue queue = new ReferenceQueue();

	private final Map<Object, SoftValueReference> map;

	private final boolean concurrent;

	public SoftCacheStorage() {
		this(new ConcurrentHashMap<>());
	}

	public SoftCacheStorage(Map<Object, SoftValueReference> map) {
		this.map = map;
		this.concurrent = map instanceof ConcurrentHashMap;
	}

	@Override
	public int getSize() {
		processQueue();
		return map.size();
	}

	@Override
	public boolean isConcurrent() {
		return false;
	}

	@Override
	public Object get(Object key) {
		processQueue();
		Reference ref = map.get(key);
		return ref == null ? null : ref.get();
	}

	@Override
	public void put(Object key, Object value) {
		processQueue();
		map.put(key, new SoftValueReference(key, value, queue));
	}

	@Override
	public void remove(Object key) {
		processQueue();
		map.remove(key);
	}

	@Override
	public void clear() {
		map.clear();
		processQueue();
	}

	private void processQueue() {
		for (;;) {
			SoftValueReference ref = (SoftValueReference) queue.poll();
			if (ref == null) {
				return;
			}
			Object key = ref.getKey();
			if (concurrent) {
				try {
					atomicRemove.invoke(map, key, ref);
				}
				catch (IllegalAccessException | InvocationTargetException e) {
					throw new UndeclaredThrowableException(e);
				}
			}
			else if (map.get(key) == ref) {
				map.remove(key);
			}
		}
	}

	private static final class SoftValueReference extends SoftReference {

		private final Object key;

		SoftValueReference(Object key, Object value, ReferenceQueue queue) {
			super(value, queue);
			this.key = key;
		}

		Object getKey() {
			return key;
		}

	}

	private static Method getAtomicRemoveMethod() {
		try {
			return Class.forName("java.util.concurrent.ConcurrentMap").getMethod("remove",
					Object.class, Object.class);
		}
		catch (ClassNotFoundException e) {
			return null;
		}
		catch (NoSuchMethodException e) {
			throw new UndeclaredThrowableException(e);
		}
	}

}
