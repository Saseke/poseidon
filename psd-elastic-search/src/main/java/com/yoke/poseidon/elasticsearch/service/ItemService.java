package com.yoke.poseidon.elasticsearch.service;

import com.yoke.poseidon.elasticsearch.entity.Item;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 上午11:11
 */
public interface ItemService {

	List<Item> getByName(@NonNull String name);

	Item add(@NonNull Item item);

	void delete(@NonNull String itemId);

	Item update(@NonNull Item item);

	Page<Item> getByKey(String name, PageRequest pageRequest);

	List<Item> getAll();

	/**
	 * 从商品展示服务同步数据
	 */
	List<Item> syncData();

	List<Item> test();

}
