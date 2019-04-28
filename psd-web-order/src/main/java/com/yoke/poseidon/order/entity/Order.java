package com.yoke.poseidon.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author yoke
 * @since 2019-02-10
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

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Order{" + "orderId='" + orderId + '\'' + ", payment=" + payment
				+ ", paymentType=" + paymentType + ", postFee=" + postFee + ", status="
				+ status + ", createTime=" + createTime + ", updateTime=" + updateTime
				+ ", paymentTime=" + paymentTime + ", endTime=" + endTime + ", closeTime="
				+ closeTime + ", shippingName='" + shippingName + '\''
				+ ", shippingCode='" + shippingCode + '\'' + ", buyerId=" + buyerId
				+ ", buyerMessage='" + buyerMessage + '\'' + ", buyerNick='" + buyerNick
				+ '\'' + ", sellerId=" + sellerId + ", sellerNick='" + sellerNick + '\''
				+ ", buyerComment=" + buyerComment + ", address='" + address + '\'' + '}';
	}

}
