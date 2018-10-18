package com.yoke.poseidon.web.dto;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @Author Yoke
 * @Date 2018/10/17 下午8:17
 */
public class ItemDto implements Serializable {

    private static final long serialVersionUID = -4001786119212330546L;
    private String itemId;
    private String title;
    private Long itemCatId;
    private String itemCatName;
    private String sellPoint;
    private BigDecimal price;
    private Integer limitNum;
    private String image;
    private String description;
    private Integer sortOrder;

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getItemCatId() {
        return itemCatId;
    }

    public void setItemCatId(Long itemCatId) {
        this.itemCatId = itemCatId;
    }

    public String getItemCatName() {
        return itemCatName;
    }

    public void setItemCatName(String itemCatName) {
        this.itemCatName = itemCatName;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemDto() {
    }

    public ItemDto(String itemId, String title, Long itemCatId, String itemCatName, String sellPoint,
                   BigDecimal price, Integer limitNum, String image, String description) {
        this.itemId = itemId;
        this.title = title;
        this.itemCatId = itemCatId;
        this.itemCatName = itemCatName;
        this.sellPoint = sellPoint;
        this.price = price;
        this.limitNum = limitNum;
        this.image = image;
        this.description = description;
    }

    @Override
    public String toString() {
        return "ItemDto{" +
                "itemId='" + itemId + '\'' +
                ", title='" + title + '\'' +
                ", itemCatId=" + itemCatId +
                ", itemCatName='" + itemCatName + '\'' +
                ", sellPoint='" + sellPoint + '\'' +
                ", price=" + price +
                ", limitNum=" + limitNum +
                ", image='" + image + '\'' +
                ", description='" + description + '\'' +
                ", sortOrder=" + sortOrder +
                '}';
    }
}
