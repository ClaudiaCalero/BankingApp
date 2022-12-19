package com.IronhackLastProject.BankingApp.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String streetName;
    private String streetNum;
    private String city;
    public Address(String streetName, String streetNum, String city) {

        this.streetName = streetName;
        this.streetNum = streetNum;
        this.city = city;
    }
    public Address() {
    }

    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getStreetNum() {
        return streetNum;
    }

    public void setStreetNum(String streetNum) {
        this.streetNum = streetNum;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
