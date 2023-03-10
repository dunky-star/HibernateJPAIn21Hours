package com.dunky.in21hours.entity;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String line1;
    private String line2;
    private String city;

    protected Address(){

    }

    public Address(String line1, String line2, String city) {
        this.line1 = line1;
        this.line2 = line2;
        this.city = city;
    }
}
