package com.example.assignment1;

import java.io.Serializable;

public class Product implements Serializable {

    private String volume;
    boolean icing;

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setIcing(boolean icing) {
        this.icing = icing;
    }

    public String getVolume() {
        return volume;
    }

    public boolean isIcing() {
        return icing;
    }
}
