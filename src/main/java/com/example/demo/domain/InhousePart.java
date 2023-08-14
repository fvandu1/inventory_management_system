package com.example.demo.domain;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Random;

/**
 *
 *
 *
 *
 */
@Entity
@DiscriminatorValue("1")
public class InhousePart extends Part {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int partId;

    public InhousePart() {
        Random rand = new Random();
        partId = rand.nextInt(10000);
    }

    public InhousePart(String name, double price, int inv) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        Random rand = new Random();
        partId = rand.nextInt(10000);
    }

    public InhousePart(String name, double price, int inv, int min, int max) {
        this.name = name;
        this.price = price;
        this.inv = inv;
        this.minInv = min;
        this.maxInv = max;
        Random rand = new Random();
        partId = rand.nextInt(10000);
    }

    public int getPartId() {
        return partId;
    }

    public void setPartId(int partId) {
        this.partId = partId;
    }
}
