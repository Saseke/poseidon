package com.yoke.poseidon.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@TableName("db_item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    /**
     * 商品名称
     */
    private String title;

    /**
     * 卖点
     */
    private String sellPoint;

    private BigDecimal price;

    /**
     * 库存
     */
    private Integer num;

    /**
     * 限制售卖的数量
     */
    private Integer limitNum;

    /**
     * 商品图片
     */
    private String image;

    /**
     * 分类id
     */
    private Integer cId;

    /**
     * 状态
     */
    private Integer status;

    private LocalDateTime created;

    private LocalDateTime updated;

    /**
     * 排序号码
     */
    private Integer sortOrder;

    /**
     * 备注
     */
    private String remark;

    /**
     * 描述
     */
    private String description;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSellPoint() {
        return sellPoint;
    }

    public void setSellPoint(String sellPoint) {
        this.sellPoint = sellPoint;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public Integer getLimitNum() {
        return limitNum;
    }

    public void setLimitNum(Integer limitNum) {
        this.limitNum = limitNum;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Item{" +
        "id=" + id +
        ", title=" + title +
        ", sellPoint=" + sellPoint +
        ", price=" + price +
        ", num=" + num +
        ", limitNum=" + limitNum +
        ", image=" + image +
        ", cId=" + cId +
        ", status=" + status +
        ", created=" + created +
        ", updated=" + updated +
        ", sortOrder=" + sortOrder +
        ", remark=" + remark +
        ", description=" + description +
        "}";
    }
}
