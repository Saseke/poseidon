package com.yoke.poseidon.web.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import java.io.Serializable;

/**
 * <p>
 * 订单运送表
 * </p>
 *
 * @author ehereal
 * @since 2018-09-20
 */
@TableName("db_order_shipping")
public class OrderShipping implements Serializable {

    private static final long serialVersionUID = 1L;

    private String orderId;

    /**
     * 收货人名称
     */
    private String receiverName;

    private String receiverMobile;

    /**
     * 省份
     */
    private String receiverState;

    /**
     * 城市
     */
    private String receiverCity;

    /**
     * 区县
     */
    private String receiverDistrict;

    /**
     * 收货地址
     */
    private String receiverAddress;

    private LocalDateTime created;

    private LocalDateTime updated;


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceiverName() {
        return receiverName;
    }

    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName;
    }

    public String getReceiverMobile() {
        return receiverMobile;
    }

    public void setReceiverMobile(String receiverMobile) {
        this.receiverMobile = receiverMobile;
    }

    public String getReceiverState() {
        return receiverState;
    }

    public void setReceiverState(String receiverState) {
        this.receiverState = receiverState;
    }

    public String getReceiverCity() {
        return receiverCity;
    }

    public void setReceiverCity(String receiverCity) {
        this.receiverCity = receiverCity;
    }

    public String getReceiverDistrict() {
        return receiverDistrict;
    }

    public void setReceiverDistrict(String receiverDistrict) {
        this.receiverDistrict = receiverDistrict;
    }

    public String getReceiverAddress() {
        return receiverAddress;
    }

    public void setReceiverAddress(String receiverAddress) {
        this.receiverAddress = receiverAddress;
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
        return "OrderShipping{" +
        "orderId=" + orderId +
        ", receiverName=" + receiverName +
        ", receiverMobile=" + receiverMobile +
        ", receiverState=" + receiverState +
        ", receiverCity=" + receiverCity +
        ", receiverDistrict=" + receiverDistrict +
        ", receiverAddress=" + receiverAddress +
        ", created=" + created +
        ", updated=" + updated +
        "}";
    }
}
