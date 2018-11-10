package com.yoke.poseidon.web.mapper;

import com.google.common.primitives.Longs;
import com.yoke.poseidon.web.entity.ItemCat;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/11/07 下午8:10
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ItemCatMapperTest {

    @Autowired
    private ItemCatMapper itemCatMapper;

    @Test
    public void selectByParentId() {
        List<ItemCat> list = itemCatMapper.selectByParentId(0L);
        Assert.assertEquals(20, list.size());
    }

    @Test
    public void selectByParentIds() {
        List<Long> list = Longs.asList(0L, 1L);
        List<ItemCat> itemCats = itemCatMapper.selectByParentIds(list);
        Assert.assertNotNull(itemCats);
    }

    @Test
    public void selectRootCat() {
        List<ItemCat> list = itemCatMapper.selectRootCat();
        Assert.assertNotNull(list);
    }
}