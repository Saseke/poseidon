package com.yoke.poseidon.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author yoke
 * @since 2018-10-27
 */
@TableName("db_item_img")
public class ItemImg implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String itemId;

    private String size;

    private String remark;

    private LocalDateTime created;

    private LocalDateTime updated;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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

    @Override
    public String toString() {
        return "ItemImg{" +
        "id=" + id +
        ", itemId=" + itemId +
        ", size=" + size +
        ", remark=" + remark +
        ", created=" + created +
        ", updated=" + updated +
        "}";
    }
}
