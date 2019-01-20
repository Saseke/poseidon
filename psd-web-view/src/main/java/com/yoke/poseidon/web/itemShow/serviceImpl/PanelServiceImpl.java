package com.yoke.poseidon.web.itemShow.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yoke.poseidon.web.itemShow.dto.ItemDto;
import com.yoke.poseidon.web.itemShow.dto.PanelDto;
import com.yoke.poseidon.web.itemShow.entity.Item;
import com.yoke.poseidon.web.itemShow.entity.Panel;
import com.yoke.poseidon.web.itemShow.mapper.ItemMapper;
import com.yoke.poseidon.web.itemShow.mapper.PanelContentMapper;
import com.yoke.poseidon.web.itemShow.mapper.PanelMapper;
import com.yoke.poseidon.web.itemShow.service.ConvertService;
import com.yoke.poseidon.web.itemShow.service.PanelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@Service
public class PanelServiceImpl extends ServiceImpl<PanelMapper, Panel>
		implements PanelService {

	private final PanelMapper panelMapper;

	private final ConvertService convertService;

	private final ItemMapper itemMapper;

	private final PanelContentMapper panelContentMapper;

	@Autowired
	public PanelServiceImpl(PanelMapper panelMapper, ConvertService convertService,
			ItemMapper itemMapper, PanelContentMapper panelContentMapper) {
		this.panelMapper = panelMapper;
		this.convertService = convertService;
		this.itemMapper = itemMapper;
		this.panelContentMapper = panelContentMapper;
	}

	@Override
	public List<PanelDto> getPanelByRemark(@NonNull String remark,
			@NonNull Integer panelLimit, @NonNull Integer itemLimit) {
		List<Panel> panelList = panelMapper.selectByRemark(remark, null, panelLimit);
		List<PanelDto> panelDtoList = convertService.convertPanel(panelList);
		panelDtoList.forEach(panelDto -> {
			List<String> itemIds = panelContentMapper
					.selectItemIdsByPanelId(panelDto.getPanelId(), itemLimit);
			List<Item> items = itemMapper.selectIdIn(itemIds, null, false);
			List<ItemDto> itemDtoList = convertService.convertItem(items);
			panelDto.setItemDtoList(itemDtoList);
		});
		return panelDtoList;
	}

	@Override
	public List<PanelDto> getPanelByItemCatId(@NonNull Long itemCatId) {
		List<Long> ids = new ArrayList<Long>() {
			{
				add(itemCatId);
			}
		};
		return getPanelByItemCatId(ids);
	}

	@Override
	public List<PanelDto> getPanelWithItemsByItemCatId(@NonNull Long itemCatId,

			@NonNull Integer limit) {
		List<Long> ids = new ArrayList<Long>() {
			{
				add(itemCatId);
			}
		};
		return getPanelWithItemsByItemCatId(ids, limit);
	}

	@Override
	public List<PanelDto> getPanelWithItemsByItemCatId(@NonNull List<Long> itemCatIds,
			@NonNull Integer itemLimit) {
		List<PanelDto> panelDtoList = getPanelByItemCatId(itemCatIds);
		panelDtoList.forEach(panelDto -> {
			List<String> itemIds = panelContentMapper
					.selectItemIdsByPanelId(panelDto.getPanelId(), itemLimit);
			if (itemIds.size() != 0) {
				List<ItemDto> itemDtoList = convertService
						.convertItem(itemMapper.selectIdIn(itemIds, null, false));
				panelDto.setItemDtoList(itemDtoList);
			}
		});
		return panelDtoList;
	}

	@Override
	public List<PanelDto> getPanelByItemCatId(@NonNull List<Long> itemCatIds) {
		List<Panel> panelList = panelMapper
				.selectList(new QueryWrapper<Panel>().in("item_cat_id", itemCatIds));
		return convertService.convertPanel(panelList);
	}

}
