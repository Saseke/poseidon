package com.yoke.poseidon.elasticsearch.dao;

import com.yoke.poseidon.elasticsearch.entity.EsItem;
import org.elasticsearch.index.query.QueryBuilders;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/12 下午5:54
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class CustomerRepositoryTest {

	@Autowired
	private ItemRepository itemRepository;

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Test
	public void test() {
		SearchQuery searchQuery = new NativeSearchQueryBuilder()
				.withQuery(QueryBuilders.fuzzyQuery("name", "yoke")).build();
		List<EsItem> list = elasticsearchTemplate.queryForList(searchQuery, EsItem.class);
		list.forEach(System.out::println);
	}

}