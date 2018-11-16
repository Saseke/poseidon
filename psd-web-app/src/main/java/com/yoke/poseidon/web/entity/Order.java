package com.yoke.poseidon.web.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@TableName("db_order")
public class Order implements Serializable {

	private static final long serialVersionUID = 1L;

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

	private LocalDateTime createTime;

	private LocalDateTime updateTime;

	private LocalDateTime paymentTime;

	private LocalDateTime endTime;

	private LocalDateTime closeTime;

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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public LocalDateTime getCreateTime() {
		return createTime;
	}

	public void setCreateTime(LocalDateTime createTime) {
		this.createTime = createTime;
	}

	public LocalDateTime getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(LocalDateTime updateTime) {
		this.updateTime = updateTime;
	}

	public LocalDateTime getPaymentTime() {
		return paymentTime;
	}

	public void setPaymentTime(LocalDateTime paymentTime) {
		this.paymentTime = paymentTime;
	}

	public LocalDateTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalDateTime endTime) {
		this.endTime = endTime;
	}

	public LocalDateTime getCloseTime() {
		return closeTime;
	}

	public void setCloseTime(LocalDateTime closeTime) {
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

	public String getBuyerNick() {
		return buyerNick;
	}

	public void setBuyerNick(String buyerNick) {
		this.buyerNick = buyerNick;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getSellerNick() {
		return sellerNick;
	}

	public void setSellerNick(String sellerNick) {
		this.sellerNick = sellerNick;
	}

	public Integer getBuyerComment() {
		return buyerComment;
	}

	public void setBuyerComment(Integer buyerComment) {
		this.buyerComment = buyerComment;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId=" + orderId + ", payment=" + payment + ", paymentType="
				+ paymentType + ", postFee=" + postFee + ", status=" + status
				+ ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", paymentTime=" + paymentTime + ", endTime=" + endTime + ", closeTime="
				+ closeTime + ", shippingName=" + shippingName + ", shippingCode="
				+ shippingCode + ", buyerId=" + buyerId + ", buyerMessage=" + buyerMessage
				+ ", buyerNick=" + buyerNick + ", sellerId=" + sellerId + ", sellerNick="
				+ sellerNick + ", buyerComment=" + buyerComment + "}";
	}

}
