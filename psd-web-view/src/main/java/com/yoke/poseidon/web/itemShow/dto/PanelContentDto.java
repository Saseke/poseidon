package com.yoke.poseidon.web.itemShow.dto;

import java.io.Serializable;

/**
 * @Author Yoke
 * @Date 2018/11/22 下午7:32
 */
public class PanelContentDto implements Serializable {

	private static final long serialVersionUID = -2008351554032341498L;

	private Integer panelContentId;

	private String panelId;

	private String picUrl;

	private String productId;

	private Integer sortOrder;

	public String getPanelId() {
		return panelId;
	}

	@Override
	public String toString() {
		return "PanelContentDto{" + "panelContentId=" + panelContentId + ", panelId='"
				+ panelId + '\'' + ", picUrl='" + picUrl + '\'' + ", productId='"
				+ productId + '\'' + ", sortOrder=" + sortOrder + '}';
	}

	public void setPanelId(String panelId) {
		this.panelId = panelId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getPanelContentId() {
		return panelContentId;
	}

	public void setPanelContentId(Integer panelContentId) {
		this.panelContentId = panelContentId;
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

}
