package com.yoke.poseidon.web.itemShow.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 * 商品参数的名称
 * </p>
 *
 * @author yoke
 * @since 2019-06-02
 */
@TableName("db_item_attribute_name")
public class ItemAttributeName implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "attribute_name_id", type = IdType.AUTO)
    private Long attributeNameId;

    /**
     * 参数名称
     */
    private String title;

    private Long cId;


    public Long getAttributeNameId() {
        return attributeNameId;
    }

    public void setAttributeNameId(Long attributeNameId) {
        this.attributeNameId = attributeNameId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getcId() {
        return cId;
    }

    public void setcId(Long cId) {
        this.cId = cId;
    }

    @Override
    public String toString() {
        return "ItemAttributeName{" +
                "attributeNameId=" + attributeNameId +
                ", title=" + title +
                ", cId=" + cId +
                "}";
    }
}
