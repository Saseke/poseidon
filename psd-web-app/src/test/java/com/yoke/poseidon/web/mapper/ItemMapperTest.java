package com.yoke.poseidon.web.mapper;

import com.google.common.collect.Lists;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/10/31 下午8:45
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemMapperTest {

    @Autowired
    private ItemMapper itemMapper;

    @Test
    public void selectByCatIds() {
        List<Long> list = Lists.newArrayList();
        list.add(22L);
        list.add(23L);
        Assert.assertNotNull(itemMapper.selectItems(list));
    }
}
