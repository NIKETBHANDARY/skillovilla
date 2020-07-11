package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@NamedQueries({
        @NamedQuery(name = "GET_LIST_OF_COUNTRY_CHARGES_FOR_COUNTRY_ID",query = "SELECT CCH FROM CountryCharges CCH WHERE CCH.country.countryID = :countryID")
})

@Entity
@Table(name = "CountryCharges")
public class CountryCharges implements Serializable {
    private static final long serialVersionUID = 4574400525956320753L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryChargesID")
    private int countryChargesID;

    @ManyToOne
    @JoinColumn(name = "CountryID")
    private Country country;

    @ManyToOne
    @JoinColumn(name = "ChargeID")
    private Charge charge;

    @Column(name = "Price")
    private BigDecimal price;

    public int getCountryChargesID() {
        return countryChargesID;
    }

    public void setCountryChargesID(int countryChargesID) {
        this.countryChargesID = countryChargesID;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Charge getCharge() {
        return charge;
    }

    public void setCharge(Charge charge) {
        this.charge = charge;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
