package com.example.mybeers.model;

import java.io.Serializable;

public class Fermentation implements Serializable {
    private Temp temp;

    public Fermentation(Temp temp) {
        this.temp = temp;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }
}
