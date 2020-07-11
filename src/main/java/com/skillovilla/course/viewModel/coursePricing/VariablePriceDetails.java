package com.skillovilla.course.viewModel.coursePricing;

import java.io.Serializable;

public class VariablePriceDetails implements Serializable {
    private static final long serialVersionUID = -6161898619531549848L;

    private String name;
    private String desc;
    private String price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
