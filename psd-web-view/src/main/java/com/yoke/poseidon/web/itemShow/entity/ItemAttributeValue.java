package com.yoke.poseidon.web.itemShow.entity;

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
@TableName("db_item_attribute_value")
public class ItemAttributeValue implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "attribute_value_id", type = IdType.AUTO)
    private Long attributeValueId;

    /**
     * 关联商品参数表
     */
    private Long attributeNameId;

    private String attributeValue;


    public Long getAttributeValueId() {
        return attributeValueId;
    }

    public void setAttributeValueId(Long attributeValueId) {
        this.attributeValueId = attributeValueId;
    }

    public Long getAttributeNameId() {
        return attributeNameId;
    }

    public void setAttributeNameId(Long attributeNameId) {
        this.attributeNameId = attributeNameId;
    }

    public String getAttributeValue() {
        return attributeValue;
    }

    public void setAttributeValue(String attributeValue) {
        this.attributeValue = attributeValue;
    }

    @Override
    public String toString() {
        return "ItemAttributeValue{" +
                "attributeValueId=" + attributeValueId +
                ", attributeNameId=" + attributeNameId +
                ", attributeValue=" + attributeValue +
                "}";
    }
}
