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

	/**
	 * 实付金额
	 */
	private BigDecimal payment;

	/**
	 * 支付方式
	 */
	private Integer paymentType;

	/**
	 * 邮费
	 */
	private BigDecimal postFee;

	private Integer status;

	private Date createTime;

	private Date updateTime;

	private Date paymentTime;

	private Date endTime;

	private Date closeTime;

	/**
	 * 物流名称
	 */
	private String shippingName;

	/**
	 * 物流单号
	 */
	private String shippingCode;

	/**
	 * 买家id
	 */
	private Long buyerId;

	/**
	 * 买家留言
	 */
	private String buyerMessage;

	private String buyerNick;

	private Long sellerId;

	private String sellerNick;

	private Integer buyerComment;

	private String address;

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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	public Date getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(Date paymentTime) {
		this.paymentTime = paymentTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(Date closeTime) {
		this.closeTime = closeTime;
	}

	public String getShippingName() {
		return shippingName;
	}

	public void setShippingName(String shippingName) {
		this.shippingName = shippingName;
	}

	public String getShippingCode() {
		return shippingCode;
	}

	public void setShippingCode(String shippingCode) {
		this.shippingCode = shippingCode;
	}

	public Long getBuyerId() {
		return buyerId;
	}

	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}

	public String getBuyerMessage() {
		return buyerMessage;
	}

	public void setBuyerMessage(String buyerMessage) {
		this.buyerMessage = buyerMessage;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public Integer getBuyerComment() {
		return buyerComment;
	}

	public void setBuyerComment(Integer buyerComment) {
		this.buyerComment = buyerComment;
	}

}
