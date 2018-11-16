package com.yoke.poseidon.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
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
@TableName("db_panel")
public class Panel implements Serializable {

	private static final long serialVersionUID = 1L;

	@TableId(value = "panel_id", type = IdType.AUTO)
	private Integer panelId;

	private LocalDateTime created;

	private Integer limitNum;

	private String name;

	private String remark;

	private Integer sortOrder;

	private Integer status;

	private Integer type;

	private LocalDateTime updated;

	public Integer getPanelId() {
		return panelId;
	}

	public void setPanelId(Integer panelId) {
		this.panelId = panelId;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public Integer getLimitNum() {
		return limitNum;
	}

	public void setLimitNum(Integer limitNum) {
		this.limitNum = limitNum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public LocalDateTime getUpdated() {
		return updated;
	}

	public void setUpdated(LocalDateTime updated) {
		this.updated = updated;
	}

	@Override
	public String toString() {
		return "Panel{" + "panelId=" + panelId + ", created=" + created + ", limitNum="
				+ limitNum + ", name=" + name + ", remark=" + remark + ", sortOrder="
				+ sortOrder + ", status=" + status + ", type=" + type + ", updated="
				+ updated + "}";
	}

}
