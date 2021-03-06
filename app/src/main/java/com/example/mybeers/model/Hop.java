package com.example.mybeers.model;

import com.example.mybeers.model.Amount;

import java.io.Serializable;

public class Hop implements Serializable {
    private String name;
    private Amount amount;
    private String add;
    private String attribute;

    public Hop(String name, Amount amount, String add, String attribute) {
        this.name = name;
        this.amount = amount;
        this.add = add;
        this.attribute = attribute;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Amount getAmount() {
        return amount;
    }

    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    public String getAdd() {
        return add;
    }

    public void setAdd(String add) {
        this.add = add;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }
}
