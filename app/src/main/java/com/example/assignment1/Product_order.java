package com.example.assignment1;

import java.io.Serializable;

public class Product_order implements Serializable
{
    String order;

    public Product_order(String order)
    {
        this.order=order;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }
}
