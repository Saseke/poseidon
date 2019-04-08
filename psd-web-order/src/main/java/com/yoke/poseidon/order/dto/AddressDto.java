package com.yoke.poseidon.order.dto;

import java.io.Serializable;

/**
 * @Author Yoke
 * @Date 2019/03/31 上午11:33
 */
public class AddressDto implements Serializable {

	private static final long serialVersionUID = -5794470688982496395L;

	private Long addressId;

	private Integer isDefault;

	private String streetName;

	private String tel;

	private Long userId;

	private String userName;

	public Long getAddressId() {
		return addressId;
	}

	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}

	public Integer getIsDefault() {
		return isDefault;
	}

	public void setIsDefault(Integer isDefault) {
		this.isDefault = isDefault;
	}

	public String getStreetName() {
		return streetName;
	}

	public void setStreetName(String streetName) {
		this.streetName = streetName;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

}
