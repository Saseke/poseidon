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
@TableName("db_panel_content")
public class PanelContent implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "panel_content_id", type = IdType.AUTO)
	private Integer panelContentId;

	private LocalDateTime createDate;

	private Integer panelId;

	private String picUrl;

	private String productId;

	private Integer sortOrder;

	private LocalDateTime modifyDate;

	public Integer getPanelContentId() {
		return panelContentId;
	}

	public void setPanelContentId(Integer panelContentId) {
		this.panelContentId = panelContentId;
	}

	public Integer getPanelId() {
		return panelId;
	}

	public void setPanelId(Integer panelId) {
		this.panelId = panelId;
	}

	public String getPicUrl() {
		return picUrl;
	}

	public void setPicUrl(String picUrl) {
		this.picUrl = picUrl;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "PanelContent{" + "panelContentId=" + panelContentId + ", createDate="
				+ createDate + ", panelId=" + panelId + ", picUrl='" + picUrl + '\''
				+ ", productId='" + productId + '\'' + ", sortOrder=" + sortOrder
				+ ", modifyDate=" + modifyDate + '}';
	}

}
