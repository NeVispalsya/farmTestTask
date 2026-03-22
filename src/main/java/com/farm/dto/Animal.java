package com.farm.dto;


import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@ToString
public abstract class Animal {
    private final UUID id;
    private final String name;
    private double price;
    private final int minProduct;
    private final int maxProduct;

    @Getter
    private static final ArrayList<Class<? extends Animal>> instantiatedDerivedTypes = new ArrayList<>();

    protected Animal(String[] names, int minProduct, int maxProduct) {
        this.name = names[(int) (Math.random() * names.length)];
        this.id = UUID.randomUUID();
        this.minProduct = minProduct;
        this.maxProduct = maxProduct;
        Class<? extends Animal> derivedClass = this.getClass();
        if (!instantiatedDerivedTypes.contains(derivedClass)) {
            instantiatedDerivedTypes.add(derivedClass);
        }
    }


    public Product createProduct() {
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
