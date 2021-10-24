package com.example.assignment1;

import androidx.annotation.NonNull;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReference;

public class Product implements Serializable {


    private String name;
    private String volume;
    private String type;
    private String fill_with_cream;


    private String icing;
    ArrayList<String> additions;

    public Product(String name, String volume, String icing) {
        this.name = name;
        this.volume = volume;
        this.icing = icing;
    }

    public Product(String name, String volume, String type, String fill_with_cream) {
        this.name = name;
        this.volume = volume;
        this.type = type;
        this.fill_with_cream = fill_with_cream;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public void setIcing(String icing) {
        this.icing = icing;
    }

    public String getVolume() {
        return volume;
    }

    public String isIcing() {
        return icing;
    }

    public String getIcing() { return icing; }

    public ArrayList<String> getAdditions() {
        return additions;
    }

    public void setAdditions( ArrayList<String> additions, String d) {
        additions.add(d);
    }


}
