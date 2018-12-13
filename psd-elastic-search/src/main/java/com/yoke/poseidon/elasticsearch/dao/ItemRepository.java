package com.yoke.poseidon.elasticsearch.dao;

import com.yoke.poseidon.elasticsearch.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 上午9:46
 */
public interface ItemRepository extends ElasticsearchRepository<Item, String> {

	List<Item> findByName(String name);

}
