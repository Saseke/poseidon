package com.yoke.poseidon.web.itemShow.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class ItemAttribute implements Serializable {

    private List<Map<Long, Long>> attributes;
    private BigDecimal price;

    public List<Map<Long, Long>> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Map<Long, Long>> attributes) {
        this.attributes = attributes;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
