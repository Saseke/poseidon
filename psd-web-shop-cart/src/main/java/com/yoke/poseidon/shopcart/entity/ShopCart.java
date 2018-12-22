package com.yoke.poseidon.shopcart.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 购物车
 * </p>
 *
 * @author yoke
 * @since 2018-12-22
 */
@TableName("db_shop_cart")
public class ShopCart implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "shop_cart_id", type = IdType.AUTO)
    private Long shopCartId;

    private Long memberId;

    private LocalDateTime created;

    private LocalDateTime updated;

    private String remark;

    private Integer shopCartStatus;


    public Long getShopCartId() {
        return shopCartId;
    }

    public void setShopCartId(Long shopCartId) {
        this.shopCartId = shopCartId;
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

    public Integer getShopCartStatus() {
        return shopCartStatus;
    }

    public void setShopCartStatus(Integer shopCartStatus) {
        this.shopCartStatus = shopCartStatus;
    }

    @Override
    public String toString() {
        return "ShopCart{" +
        "shopCartId=" + shopCartId +
        ", memberId=" + memberId +
        ", created=" + created +
        ", updated=" + updated +
        ", remark=" + remark +
        ", shopCartStatus=" + shopCartStatus +
        "}";
    }
}
