package com.yoke.poseidon.web.itemShow.dto;

import java.io.Serializable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Author Yoke
 * @Date 2018/11/22 下午7:31
 */
public class PanelDto implements Serializable {

	private Integer panelId;

	private Integer limitNum;

	private String name;

	private String remark;

	private Integer sortOrder;

	private Integer status;

	private Integer type;

	private Long itemCatId;

	private List<ItemDto> itemDtoList;

	public PanelDto() {
		itemDtoList = newArrayList();
	}

	public Integer getPanelId() {
		return panelId;
	}

	public void setPanelId(Integer panelId) {
		this.panelId = panelId;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public List<ItemDto> getItemDtoList() {
		return itemDtoList;
	}

	public void setItemDtoList(List<ItemDto> itemDtoList) {
		this.itemDtoList = itemDtoList;
	}

	public Long getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
	}

}
