package com.yoke.poseidon.web.itemShow.dto;

import java.io.Serializable;
import java.util.List;

import static com.google.common.collect.Lists.newArrayList;

/**
 * @Author Yoke
 * @Date 2018/10/17 下午9:56
 */
public class ItemCatDto implements Serializable {

	private static final long serialVersionUID = 3026371933152829463L;

	private Long itemCatId;

	private String icon;

	private Boolean isParent;

	private String name;

	private Long parentId;

	private String remark;

	private Integer sortOrder;

	private List<ItemCatDto> childCats;

	private List<ItemDto> items;

	public ItemCatDto() {
		childCats = newArrayList();
		items = newArrayList();
	}

	public Long getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getIcon() {
		return icon;
	}

	public void setIcon(String icon) {
		this.icon = icon;
	}

	public Boolean getIsParent() {
		return isParent;
	}

	public void setIsParent(Boolean isParent) {
		this.isParent = isParent;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public List<ItemCatDto> getChildCats() {
		return childCats;
	}

	public void setChildCats(List<ItemCatDto> childCats) {
		this.childCats = childCats;
	}

	public List<ItemDto> getItems() {
		return items;
	}

	public void setItems(List<ItemDto> items) {
		this.items = items;
	}

}
