package com.yoke.poseidon.web.itemShow.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author Yoke
 * @Date 2018/10/17 下午8:17
 */
public class ItemDto implements Serializable {

	private static final long serialVersionUID = -4001786119212330546L;

	private String itemId;

	private String name;

	private Long cId;

	private String itemCatName;

	private String sellPoint;

	private BigDecimal price;

	private Integer limitNum;

	private String image;

	private String remark;

	private String description;

	private Integer sortOrder;

	private Integer sale;

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Integer getSale() {
		return sale;
	}

	public void setSale(Integer sale) {
		this.sale = sale;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Long getcId() {
		return cId;
	}

	public void setcId(Long cId) {
		this.cId = cId;
	}

	public String getItemCatName() {
		return itemCatName;
	}

	public void setItemCatName(String itemCatName) {
		this.itemCatName = itemCatName;
	}

	public String getSellPoint() {
		return sellPoint;
	}

	public void setSellPoint(String sellPoint) {
		this.sellPoint = sellPoint;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "ItemDto{" + "itemId='" + itemId + '\'' + ", name='" + name + '\''
				+ ", cId=" + cId + ", itemCatName='" + itemCatName + '\''
				+ ", sellPoint='" + sellPoint + '\'' + ", price=" + price + ", limitNum="
				+ limitNum + ", image='" + image + '\'' + ", remark='" + remark + '\''
				+ ", description='" + description + '\'' + ", sortOrder=" + sortOrder
				+ ", sale=" + sale + '}';
	}

}
