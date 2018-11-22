package com.yoke.poseidon.web.itemShow.entity;

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
 * @author yoke
 * @since 2018-11-22
 */
@TableName("db_item_cat")
public class ItemCat implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "item_cat_id", type = IdType.AUTO)
    private Long itemCatId;

    private LocalDateTime created;

    private String icon;

    private Boolean isParent;

    private String name;

    private Long parentId;

    private String remark;

    private Integer sortOrder;

    private Integer state;

    private LocalDateTime updated;


    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public void setCreated(LocalDateTime created) {
        this.created = created;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean isParent) {
        this.isParent = isParent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
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

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public LocalDateTime getUpdated() {
        return updated;
    }

    public void setUpdated(LocalDateTime updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "ItemCat{" +
        "itemCatId=" + itemCatId +
        ", created=" + created +
        ", icon=" + icon +
        ", isParent=" + isParent +
        ", name=" + name +
        ", parentId=" + parentId +
        ", remark=" + remark +
        ", sortOrder=" + sortOrder +
        ", state=" + state +
        ", updated=" + updated +
        "}";
    }
}
