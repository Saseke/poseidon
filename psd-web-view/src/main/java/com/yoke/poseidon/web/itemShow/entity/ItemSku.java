package com.yoke.poseidon.web.itemShow.entity;

import java.math.BigDecimal;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author yoke
 * @since 2019-06-02
 */
@TableName("db_item_sku")
public class ItemSku implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "item_sku_id", type = IdType.AUTO)
    private Long itemSkuId;

    private String itemId;

    /**
     * 参数名:参数值这种形式
     */
    private String attributes;

    private BigDecimal price;

    private BigDecimal cost;

    /**
     * 库存
     */
    private Integer stock;


    public Long getItemSkuId() {
        return itemSkuId;
    }

    public void setItemSkuId(Long itemSkuId) {
        this.itemSkuId = itemSkuId;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getAttributes() {
        return attributes;
    }

    public void setAttributes(String attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "ItemSku{" +
                "itemSkuId=" + itemSkuId +
                ", itemId=" + itemId +
                ", attributes=" + attributes +
                ", price=" + price +
                ", cost=" + cost +
                ", stock=" + stock +
                "}";
    }
}
