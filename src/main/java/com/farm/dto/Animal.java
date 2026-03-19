package com.farm.dto;


import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public abstract class Animal implements Producer {
    private final UUID id;
    private Product product;
    private final String name;
    private double price;
    private int minProduct;
    private int maxProduct;

    protected Animal(String[] names) {
        this.name = names[(int) (Math.random() * names.length)];
        this.id = UUID.randomUUID();
    }

    protected abstract Product createProduct();

    @Override
    public List<Product> produce() {
        List<Product> result = new ArrayList<>();
        int amount = minProduct + (int) (Math.random() * (maxProduct - minProduct + 1));
        for (int i = 0; i < amount; i++) {
            result.add(createProduct());
        }
        return result;
    }
}
