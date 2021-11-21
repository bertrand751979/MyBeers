package com.example.mybeers.model;

import java.io.Serializable;

public class MashTemp implements Serializable {
    private Temp temp;
    private int duration;


    public MashTemp(Temp temp, int duration) {
        this.temp = temp;
        this.duration = duration;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
