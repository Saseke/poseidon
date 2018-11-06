package com.yoke.poseidon.web.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/30 下午10:12
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCatMapperTest {
    @Autowired
    private ItemCatMapper itemCatMapper;

    @Test
    public void test() {
        List<Long> list = new ArrayList<>();
        list.add(1L);
        itemCatMapper.getChildCat(list);
    }
}
