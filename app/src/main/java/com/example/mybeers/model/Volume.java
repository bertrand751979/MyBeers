package com.example.mybeers.model;

import java.io.Serializable;

public class Volume implements Serializable {
    private  int value;
    private  String unit;

    public Volume(int value, String unit) {
        this.value = value;
        this.unit = unit;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }
}
