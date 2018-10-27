package com.yoke.poseidon.web.serviceImpl;

import com.yoke.poseidon.web.dto.ItemCatDto;
import com.yoke.poseidon.web.dto.ItemDto;
import com.yoke.poseidon.web.entity.Item;
import com.yoke.poseidon.web.entity.ItemCat;
import com.yoke.poseidon.web.service.ConvertService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author Yoke
 * @Date 2018/10/23 下午3:19
 */

@Service
public class ConvertServiceImpl implements ConvertService {

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ItemDto convert(Item item) {
        return modelMapper.map(item, ItemDto.class);
    }

    @Override
    public ItemCatDto convert(ItemCat itemCat) {
        return modelMapper.map(itemCat, ItemCatDto.class);
    }
}
