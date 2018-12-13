package com.yoke.poseidon.web.itemShow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.itemShow.dto.PanelDto;
import com.yoke.poseidon.web.itemShow.entity.Panel;
import org.springframework.lang.NonNull;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
public interface PanelService extends IService<Panel> {

	List<PanelDto> getPanelByRemark(@NonNull String remark, String panelSort,
			Integer panelLimit, String itemSort, Integer itemLimit);

}
