package com.yoke.poseidon.elasticsearch.service.impl;

import com.google.common.collect.Lists;
import com.yoke.poseidon.elasticsearch.dao.ItemRepository;
import com.yoke.poseidon.elasticsearch.entity.EsItem;
import com.yoke.poseidon.elasticsearch.feign.ItemFeign;
import com.yoke.poseidon.elasticsearch.service.ItemService;
import org.elasticsearch.action.bulk.BulkRequestBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
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

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Autowired
	private ItemFeign itemFeign;

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
	public Page<EsItem> getByKey(String keyWord, int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		QueryBuilder queryBuilder = QueryBuilders.boolQuery()
				.should(QueryBuilders.matchQuery("name", keyWord))
				.should(QueryBuilders.matchQuery("sellPoint", keyWord));
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
		nativeSearchQueryBuilder.withQuery(queryBuilder).withPageable(pageable)
				.withSort(SortBuilders.fieldSort("sale").order(SortOrder.DESC));
		NativeSearchQuery query = nativeSearchQueryBuilder.build();
		LOGGER.info("DSL:{}", query.getQuery().toString());
		return itemRepository.search(query);
	}

	@Override
	public EsItem getById(String itemId) {
		return itemRepository.findByItemId(itemId);
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
	public List<EsItem> recommend(String itemId, int page, int size) {
		EsItem esItem = getById(itemId);
		QueryBuilder queryBuilder = QueryBuilders.matchQuery("name", esItem.getName());
		return Lists.newArrayList(itemRepository.search(queryBuilder));
	}

	@Override
	public List<EsItem> test() {
	    BulkRequestBuilder
	}


}
