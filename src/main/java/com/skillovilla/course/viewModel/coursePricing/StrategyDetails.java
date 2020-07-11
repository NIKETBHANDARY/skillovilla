package com.skillovilla.course.viewModel.coursePricing;

import java.io.Serializable;

public class StrategyDetails implements Serializable {
    private static final long serialVersionUID = -2285400598503257807L;

    private String name;

    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
