package com.farm.dto;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
public class Animal{
    private final UUID id;
    private final String name;
    private double price;
    private final int  minProduct;
    private final int  maxProduct;

    protected Animal(String[] names, int minProduct, int maxProduct) {
        this.name = names[(int) (Math.random() * names.length)];
        this.id = UUID.randomUUID();
        this.minProduct = minProduct;
        this.maxProduct = maxProduct;
    }

    public Product createProduct(){
        return new Product();
    }

    public List<Product> produce() {
        List<Product> result = new ArrayList<>();
        int amount = minProduct + (int) (Math.random() * (maxProduct - minProduct + 1));
        for (int i = 0; i < amount; i++) {
            result.add(createProduct());
        }
        return result;
    }
}
