package com.yoke.poseidon.order.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2019/02/10 下午2:50
 */
public class OrderDto implements Serializable {

	private static final long serialVersionUID = -2669286586484973878L;

	private String orderId;

	private BigDecimal payment;

	private Integer paymentType;

	private BigDecimal postFee;

	private Date createTime;

	private String buyerNick;

	private String sellerNick;

	private List<OrderItemDto> orderItemDtoList;

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public BigDecimal getPayment() {
		return payment;
	}

	public void setPayment(BigDecimal payment) {
		this.payment = payment;
	}

	public Integer getPaymentType() {
		return paymentType;
	}

	public void setPaymentType(Integer paymentType) {
		this.paymentType = paymentType;
	}

	public BigDecimal getPostFee() {
		return postFee;
	}

	public void setPostFee(BigDecimal postFee) {
		this.postFee = postFee;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public List<OrderItemDto> getOrderItemDtoList() {
		return orderItemDtoList;
	}

	public void setOrderItemDtoList(List<OrderItemDto> orderItemDtoList) {
		this.orderItemDtoList = orderItemDtoList;
	}

}
