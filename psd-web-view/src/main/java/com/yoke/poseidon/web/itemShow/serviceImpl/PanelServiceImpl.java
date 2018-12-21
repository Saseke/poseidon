package com.yoke.poseidon.web.itemShow.serviceImpl;

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

	@Autowired
	private PanelMapper panelMapper;

	@Autowired
	private ConvertService convertService;

	@Autowired
	private ItemMapper itemMapper;

	@Autowired
	private PanelContentMapper panelContentMapper;

	@Override
	public List<PanelDto> getPanelByRemark(@NonNull String remark, Integer panelLimit,
			Integer itemLimit) {
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
		List<Panel> panelList = panelMapper.selectByCatId(itemCatId);
		return convertService.convertPanel(panelList);
	}

	@Override
	public List<PanelDto> getPanelWithItemsByItemCatId(@NonNull Long itemCatId,
			Integer limit) {
		List<PanelDto> panelDtoList = getPanelByItemCatId(itemCatId);
		panelDtoList.forEach(panelDto -> {
			List<String> itemIds = panelContentMapper
					.selectItemIdsByPanelId(panelDto.getPanelId(), limit);
			if (itemIds.size() != 0) {
				List<ItemDto> itemDtoList = convertService
						.convertItem(itemMapper.selectIdIn(itemIds, null, false));
				panelDto.setItemDtoList(itemDtoList);
			}
		});
		return panelDtoList;
	}

}
