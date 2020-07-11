package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name = "GET_LIST_OF_CHARGE_FOR_LIST_OF_CHARGE_ID",query = "SELECT CHA From Charge CHA Where CHA.chargeID IN (:chargeIDs)"),
        @NamedQuery(name = "GET_LIST_CHARGE_WHICH_IS_DEFAULT_WITHOUT_COUNTRY",query = "SELECT CHA From Charge CHA Where CHA.isDefault = true AND CHA.isCountryWise = false"),
        @NamedQuery(name = "GET_LIST_CHARGE_WHICH_IS_DEFAULT_FOR_COUNTRY",query = "SELECT CHA From Charge CHA Where CHA.isDefault = true AND CHA.isCountryWise = true")
})

@Entity
@Table(name = "Charge")
public class Charge implements Serializable {
    private static final long serialVersionUID = 6097379909894295733L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChargeID")
    private int chargeID;

    @Column(name = "Name")
    private String name;

    @Column(name = "Description")
    private String description;

    @Column(name = "Price")
    private BigDecimal price;

    @Column(name = "IsCountryWise")
    private boolean isCountryWise;

    @Column(name = "IsDefault")
    private boolean isDefault;

    public int getChargeID() {
        return chargeID;
    }

    public void setChargeID(int chargeID) {
        this.chargeID = chargeID;
    }

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

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public boolean isCountryWise() {
        return isCountryWise;
    }

    public void setCountryWise(boolean countryWise) {
        isCountryWise = countryWise;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
