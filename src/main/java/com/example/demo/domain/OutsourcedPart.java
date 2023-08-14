package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("2")
public class OutsourcedPart extends Part {

    String companyName;

    public OutsourcedPart() {
    }

    public OutsourcedPart(String name, double price, int inv, String companyName) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.companyName = companyName;
    }

    public OutsourcedPart(String name, double price, int inv, String companyName, int min, int max) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.companyName = companyName;
        this.minInv = min;
        this.maxInv = max;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
}
