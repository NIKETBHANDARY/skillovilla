package com.skillovilla.course.model;

import javax.persistence.*;
import java.io.Serializable;

@NamedQueries({
        @NamedQuery(name = "GET_COUNTRY_BY_COUNTRY_CODE",query = "SELECT COT FROM Country COT WHERE COT.countryCode = :countryCode")
})

@Entity
@Table(name = "Country")
public class Country implements Serializable {
    private static final long serialVersionUID = -1526483524010630512L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "CountryID")
    private int countryID;

    @Column(name = "CountryCode")
    private String countryCode;

    @Column(name = "Country")
    private String country;

    @Column(name = "IsDefault",columnDefinition = "boolean default false",nullable = false)
    private boolean isDefault;


    public int getCountryID() {
        return countryID;
    }

    public void setCountryID(int countryID) {
        this.countryID = countryID;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public boolean isDefault() {
        return isDefault;
    }

    public void setDefault(boolean aDefault) {
        isDefault = aDefault;
    }
}
