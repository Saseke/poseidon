package com.yoke.poseidon.cart.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author Yoke
 * @Date 2019/01/11 下午8:48
 */
public class ItemCartDto implements Serializable {

	private static final long serialVersionUID = 1808627743375856813L;

	private Long itemCartId;

	private Long memberId;

	private Date createDate;

	private Date modifyDate;

	private String remark;

	private Integer itemCartStatus;

	/**
	 * 数量
	 */
	private Integer quantity;

	private String itemId;

	private BigDecimal price;

	private Long itemCatId;

	private String memberNickname;

	public Long getItemCartId() {
		return itemCartId;
	}

	public void setItemCartId(Long itemCartId) {
		this.itemCartId = itemCartId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getItemCartStatus() {
		return itemCartStatus;
	}

	public void setItemCartStatus(Integer itemCartStatus) {
		this.itemCartStatus = itemCartStatus;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Long getItemCatId() {
		return itemCatId;
	}

	public void setItemCatId(Long itemCatId) {
		this.itemCatId = itemCatId;
	}

	public String getMemberNickname() {
		return memberNickname;
	}

	public void setMemberNickname(String memberNickname) {
		this.memberNickname = memberNickname;
	}

	@Override
	public String toString() {
		return "ItemCartDto{" + "itemCartId=" + itemCartId + ", memberId=" + memberId
				+ ", createDate=" + createDate + ", modifyDate=" + modifyDate
				+ ", remark='" + remark + '\'' + ", itemCartStatus=" + itemCartStatus
				+ ", quantity=" + quantity + ", itemId='" + itemId + '\'' + ", price="
				+ price + ", itemCatId=" + itemCatId + ", memberNickname='"
				+ memberNickname + '\'' + '}';
	}

}
