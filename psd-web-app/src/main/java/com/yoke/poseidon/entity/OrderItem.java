package com.yoke.poseidon.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 * 订单商品关联表
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@TableName("db_order_item")
public class OrderItem implements Serializable {

    private static final long serialVersionUID = 1L;

    private String id;

    private String itemId;

    private String orderId;

    /**
     * 商品购买的数量
     */
    private Integer itemNum;

    /**
     * 商品单价
     */
    private BigDecimal itemPrice;

    /**
     * 商品总金额
     */
    private BigDecimal itemTotalPrice;


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

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Integer getItemNum() {
        return itemNum;
    }

    public void setItemNum(Integer itemNum) {
        this.itemNum = itemNum;
    }

    public BigDecimal getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(BigDecimal itemPrice) {
        this.itemPrice = itemPrice;
    }

    public BigDecimal getItemTotalPrice() {
        return itemTotalPrice;
    }

    public void setItemTotalPrice(BigDecimal itemTotalPrice) {
        this.itemTotalPrice = itemTotalPrice;
    }

    @Override
    public String toString() {
        return "OrderItem{" +
        "id=" + id +
        ", itemId=" + itemId +
        ", orderId=" + orderId +
        ", itemNum=" + itemNum +
        ", itemPrice=" + itemPrice +
        ", itemTotalPrice=" + itemTotalPrice +
        "}";
    }
}
