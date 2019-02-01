package com.yoke.poseidon.elasticsearch.service.impl;

import com.yoke.poseidon.elasticsearch.dao.ItemRepository;
import com.yoke.poseidon.elasticsearch.entity.EsItem;
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

import javax.validation.constraints.NotNull;
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
	public List<EsItem> getByName(@NonNull String name) {
		return itemRepository.findByName(name);
	}

	@Override
	public EsItem add(@NonNull EsItem esItem) {
		return itemRepository.save(esItem);
	}

	@Override
	public void delete(@NonNull String itemId) {
		itemRepository.deleteById(itemId);
	}

	@Override
	public EsItem update(@NonNull EsItem esItem) {
		return itemRepository.save(esItem);
	}

	@Override
	public EsItem create(@NotNull EsItem esItem) {
		return null;
	}

	public Page<EsItem> getByKey(String name, PageRequest pageRequest) {
		QueryBuilder queryBuilder = QueryBuilders.fuzzyQuery("name", name);
		return itemRepository.search(queryBuilder, pageRequest);
	}

	@Override
	public List<EsItem> getAll() {
		SearchQuery searchQuery = new NativeSearchQueryBuilder().build();
		return elasticsearchTemplate.queryForList(searchQuery, EsItem.class);
	}

	@Override
	public List<EsItem> syncData() {
		List<EsItem> esItemList = itemFeign.fetch();
		itemRepository.saveAll(esItemList);
		return getAll();
	}

	@Override
	public List<EsItem> recommend() {
		return null;
	}

	@Override
	public List<EsItem> test() {
		return itemFeign.fetch();
	}

}
