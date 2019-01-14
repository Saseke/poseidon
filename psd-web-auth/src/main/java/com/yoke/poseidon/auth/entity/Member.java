package com.yoke.poseidon.auth.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author yoke
 * @since 2018-11-25
 */
@TableName("db_member")
public class Member implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "member_id", type = IdType.AUTO)
	private Long memberId;

	private String address;

	private BigDecimal balance;

	private LocalDateTime createDate;

	private String description;

	private String email;

	private String password;

	private String phone;

	private Integer point;

	private Boolean sex;

	private Integer state;

	private LocalDateTime modifyDate;

	private String username;

	private String remark;

	public Long getMemberId() {
		return memberId;
	}

	public void setMemberId(Long memberId) {
		this.memberId = memberId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	public Boolean getSex() {
		return sex;
	}

	public void setSex(Boolean sex) {
		this.sex = sex;
	}

	public Integer getState() {
		return state;
	}

	public void setState(Integer state) {
		this.state = state;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(LocalDateTime modifyDate) {
		this.modifyDate = modifyDate;
	}

	@Override
	public String toString() {
		return "Member{" + "memberId=" + memberId + ", address='" + address + '\''
				+ ", balance=" + balance + ", createDate=" + createDate
				+ ", description='" + description + '\'' + ", email='" + email + '\''
				+ ", password='" + password + '\'' + ", phone='" + phone + '\''
				+ ", point=" + point + ", sex=" + sex + ", state=" + state
				+ ", modifyDate=" + modifyDate + ", username='" + username + '\''
				+ ", remark='" + remark + '\'' + '}';
	}

}
