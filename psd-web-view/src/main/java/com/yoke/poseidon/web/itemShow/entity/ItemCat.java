package com.yoke.poseidon.web.itemShow.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author yoke
 * @since 2018-11-22
 */
@TableName("db_item_cat")
public class ItemCat implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "item_cat_id", type = IdType.AUTO)
	private Long itemCatId;

	private LocalDateTime createDate;

	private String icon;

	private Boolean isParent;

	private String name;

	private Long parentId;

	private String remark;

	private Integer sortOrder;

	private Integer state;

	private LocalDateTime modifyDate;

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

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public Boolean getParent() {
		return isParent;
	}

	public void setParent(Boolean parent) {
		isParent = parent;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "ItemCat{" + "itemCatId=" + itemCatId + ", createDate=" + createDate
				+ ", icon='" + icon + '\'' + ", isParent=" + isParent + ", name='" + name
				+ '\'' + ", parentId=" + parentId + ", remark='" + remark + '\''
				+ ", sortOrder=" + sortOrder + ", state=" + state + ", modifyDate="
				+ modifyDate + '}';
	}

}
