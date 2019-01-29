package com.yoke.poseidon.elasticsearch.service.impl;

import com.yoke.poseidon.elasticsearch.dao.ItemRepository;
import com.yoke.poseidon.elasticsearch.entity.Item;
import com.yoke.poseidon.elasticsearch.feign.ItemFeign;
import com.yoke.poseidon.elasticsearch.service.ItemService;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 上午11:13
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private ItemFeign itemFeign;

	@Override
	public List<Item> getByName(@NonNull String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public Item add(@NonNull Item item) {
		return itemRepository.save(item);
	}

	@Override
	public void delete(@NonNull String itemId) {
		itemRepository.deleteById(itemId);
	}

	@Override
	public Item update(@NonNull Item item) {
		return itemRepository.save(item);
	}

	public Page<Item> getByKey(String name, PageRequest pageRequest) {
		QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", name);
		return itemRepository.search(queryBuilder, pageRequest);
	}

	@Override
	public List<Item> getAll() {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
		return elasticsearchTemplate.queryForList(searchQuery, Item.class);
	}

	@Override
	public List<Item> syncData() {
		List<Item> itemList = itemFeign.fetch();
		itemRepository.saveAll(itemList);
		return getAll();
	}

	@Override
	public List<Item> test() {
		return itemFeign.fetch();
	}

}
