package com.yoke.poseidon.elasticsearch.dao;

import com.yoke.poseidon.elasticsearch.entity.EsItem;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 上午9:46
 */
public interface ItemRepository extends ElasticsearchRepository<EsItem, String> {

	List<EsItem> findByName(String name);

}
