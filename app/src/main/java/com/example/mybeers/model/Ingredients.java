package com.example.mybeers.model;

import java.io.Serializable;
import java.util.List;

public class Ingredients implements Serializable {
    public List<Malt> malt;
    public List<Hop> hops;
    public String yeast;

    public Ingredients(List<Malt> malt, List<Hop> hops, String yeast) {
        this.malt = malt;
        this.hops = hops;
        this.yeast = yeast;
    }

    public List<Malt> getMalt() {
        return malt;
    }

    public void setMalt(List<Malt> malt) {
        this.malt = malt;
    }

    public List<Hop> getHops() {
        return hops;
    }

    public void setHops(List<Hop> hops) {
        this.hops = hops;
    }

    public String getYeast() {
        return yeast;
    }

    public void setYeast(String yeast) {
        this.yeast = yeast;
    }
}
