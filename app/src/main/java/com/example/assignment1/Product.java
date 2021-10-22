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
    boolean icing;
    ArrayList<String> additions;



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public ArrayList<String> getAdditions() {
        return additions;
    }

    public void setAdditions( ArrayList<String> additions, String d) {
        additions.add(d);
    }

    public static void writeFile() throws IOException {
        ObjectOutputStream fout= new ObjectOutputStream(new FileOutputStream("Orders.bin"));
    }

    public static void readFile()
    {

    }

}
