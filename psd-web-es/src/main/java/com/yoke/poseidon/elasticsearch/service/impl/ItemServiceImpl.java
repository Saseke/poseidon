package com.yoke.poseidon.elasticsearch.service.impl;

import com.yoke.poseidon.elasticsearch.dao.ItemRepository;
import com.yoke.poseidon.elasticsearch.entity.EsItem;
import com.yoke.poseidon.elasticsearch.feign.ItemFeign;
import com.yoke.poseidon.elasticsearch.service.ItemService;
import org.elasticsearch.index.query.MoreLikeThisQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.search.sort.SortBuilders;
import org.elasticsearch.search.sort.SortOrder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/13 上午11:13
 */
@Service
public class ItemServiceImpl implements ItemService {

	private static final Logger LOGGER = LoggerFactory.getLogger(ItemServiceImpl.class);

	private final ItemRepository itemRepository;

	private final ElasticsearchTemplate elasticsearchTemplate;

	private final ItemFeign itemFeign;

	public ItemServiceImpl(ItemRepository itemRepository, ElasticsearchTemplate elasticsearchTemplate,
			ItemFeign itemFeign) {
		this.itemRepository = itemRepository;
		this.elasticsearchTemplate = elasticsearchTemplate;
		this.itemFeign = itemFeign;
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
	public Page<EsItem> getByKey(String keyWord, int page, int limit) {
		Pageable pageable = PageRequest.of(page, limit);
		QueryBuilder queryBuilder = QueryBuilders.boolQuery().should(QueryBuilders.matchQuery("name", keyWord))
				.should(QueryBuilders.matchQuery("sellPoint", keyWord));
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
		nativeSearchQueryBuilder.withQuery(queryBuilder).withPageable(pageable)
				.withSort(SortBuilders.fieldSort("sale").order(SortOrder.DESC));
		NativeSearchQuery query = nativeSearchQueryBuilder.build();
		LOGGER.info("DSL:{}", query.getQuery().toString());
		return elasticsearchTemplate.queryForPage(query, EsItem.class);
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
	public Page<EsItem> recommend(List<String> itemIds, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		String[] itemCatNames;
		if (itemIds.size() != 0) {
			List<EsItem> esItems = itemRepository.findByItemIdIn(itemIds);
			itemCatNames = esItems.stream().map(EsItem::getItemCatName).toArray(String[]::new);
		}
		else {
			itemCatNames = new String[] { "手机" };
		}
		System.out.println(Arrays.toString(itemCatNames));
		MoreLikeThisQueryBuilder moreLikeThisQueryBuilder = QueryBuilders
				.moreLikeThisQuery(new String[] { "itemCatName" }, itemCatNames, null).minTermFreq(1);
		NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
		nativeSearchQueryBuilder.withQuery(moreLikeThisQueryBuilder).withPageable(pageable)
				.withSort(SortBuilders.fieldSort("sale").order(SortOrder.DESC));
		NativeSearchQuery query = nativeSearchQueryBuilder.build();
		// return elasticsearchTemplate.queryForPage(query, EsItem.class);
		return itemRepository.search(query);
	}

	@Override
	public Page<EsItem> queryPriceRange(BigDecimal price1, BigDecimal price2, int page, int size) {
		Pageable pageable = PageRequest.of(page, size);
		RangeQueryBuilder rangeQueryBuilder = QueryBuilders.rangeQuery("price").gt(price1).lt(price2);
		NativeSearchQuery query = new NativeSearchQueryBuilder().withQuery(rangeQueryBuilder).withPageable(pageable)
				.build();
		return itemRepository.search(query);
	}

}
