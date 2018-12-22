package com.yoke.poseidon.shopcart.dto;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author Yoke
 * @Date 2018/12/21 下午12:01
 */
public class ShopCartDto implements Serializable {

	private static final long serialVersionUID = 6798331546617359687L;

	private Integer shopcartId;

	private Long memberId;

	private LocalDateTime created;

	private LocalDateTime updated;

	private String remark;

	private List<ItemDto> itemDtoList;

	public List<ItemDto> getItemDtoList() {
		return itemDtoList;
	}

	public ShopCartDto() {
		this.itemDtoList = new ArrayList<>();
	}

	public void setItemDtoList(List<ItemDto> itemDtoList) {
		this.itemDtoList = itemDtoList;
	}

	public Integer getShopcartId() {
		return shopcartId;
	}

	public void setShopcartId(Integer shopcartId) {
		this.shopcartId = shopcartId;
	}

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

}
