package com.example.mybeers.model;

import com.example.mybeers.model.Fermentation;
import com.example.mybeers.model.MashTemp;

import java.io.Serializable;
import java.util.List;

public class Method implements Serializable {
    public List<MashTemp> mash_temp;
    public Fermentation fermentation;
    public String twist;

    public Method(List<MashTemp> mash_temp, Fermentation fermentation, String twist) {
        this.mash_temp = mash_temp;
        this.fermentation = fermentation;
        this.twist = twist;
    }

    public List<MashTemp> getMash_temp() {
        return mash_temp;
    }

    public void setMash_temp(List<MashTemp> mash_temp) {
        this.mash_temp = mash_temp;
    }

    public Fermentation getFermentation() {
        return fermentation;
    }

    public void setFermentation(Fermentation fermentation) {
        this.fermentation = fermentation;
    }

    public String getTwist() {
        return twist;
    }

    public void setTwist(String twist) {
        this.twist = twist;
    }
}
