package com.yoke.poseidon.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author Yoke
 * @Date 2019/02/10 下午4:50
 */
public class OrderItemDto implements Serializable {

	private String id;

	private String itemId;

	private String orderId;

	/**
	 * 商品购买的数量
	 */
	private Integer itemNum;

	/**
	 * 商品单价
	 */
	private BigDecimal itemPrice;

	/**
	 * 商品总金额
	 */
	private BigDecimal itemTotalPrice;

	private String itemName;

	private String itemImage;

	private String itemSellPoint;

	public String getItemImage() {
		return itemImage;
	}

	public void setItemImage(String itemImage) {
		this.itemImage = itemImage;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public Integer getItemNum() {
		return itemNum;
	}

	public void setItemNum(Integer itemNum) {
		this.itemNum = itemNum;
	}

	public BigDecimal getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}

	public BigDecimal getItemTotalPrice() {
		return itemTotalPrice;
	}

	public void setItemTotalPrice(BigDecimal itemTotalPrice) {
		this.itemTotalPrice = itemTotalPrice;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public String getItemSellPoint() {
		return itemSellPoint;
	}

	public void setItemSellPoint(String itemSellPoint) {
		this.itemSellPoint = itemSellPoint;
	}

}
