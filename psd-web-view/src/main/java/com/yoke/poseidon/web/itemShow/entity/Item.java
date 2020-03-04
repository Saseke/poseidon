package com.yoke.poseidon.web.itemShow.entity;

import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * <p>
 * 商品表
 * </p>
 *
 * @author yoke
 * @since 2018-11-22
 */
@TableName("db_item")
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;

    private String itemId;

    /**
     * 商品名称
     */
    @NotNull
    @Size(max = 64)
    private String name;

    /**
     * 卖点
     */
    @NotNull
    private String sellPoint;

    @NotNull
    private BigDecimal price;

    /**
     * 库存
     */
    @NotNull
    private Integer num;

    /**
     * 限制售卖的数量
     */
    @NotNull
    private Integer limitNum;

    /**
     * 商品图片
     */
    @NotNull
    private String image;

    /**
     * 分类id
     */
    @NotNull
    private Long cId;

    /**
     * 状态
     */
    private Integer status;

    private LocalDateTime createDate;

    private LocalDateTime modifyDate;

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

    /**
     * 销量
     */
    private Integer sale;

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

}
