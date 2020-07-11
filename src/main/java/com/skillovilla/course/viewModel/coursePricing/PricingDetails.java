package com.skillovilla.course.viewModel.coursePricing;

import java.io.Serializable;
import java.util.List;

public class PricingDetails implements Serializable {
    private static final long serialVersionUID = -3584179903023039988L;

    private String price;
    private List<VariablePriceDetails> variablePrices;
    private String totalPrice;

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<VariablePriceDetails> getVariablePrices() {
        return variablePrices;
    }

    public void setVariablePrices(List<VariablePriceDetails> variablePrices) {
        this.variablePrices = variablePrices;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }
}
