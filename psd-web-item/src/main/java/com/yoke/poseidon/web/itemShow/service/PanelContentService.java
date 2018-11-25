package com.yoke.poseidon.web.itemShow.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yoke.poseidon.web.itemShow.entity.PanelContent;
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
public interface PanelContentService extends IService<PanelContent> {

	List<String> getItemIdByPanelId(@NonNull Integer panelId, Integer limit);

}
