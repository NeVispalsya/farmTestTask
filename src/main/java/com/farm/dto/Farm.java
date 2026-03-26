package com.farm.dto;

import com.farm.factory.ChickenFactory;
import com.farm.factory.CowFactory;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Farm {
    @Getter @Setter
    private String name;
    @Getter @Setter
    private double balance;
    @Getter
    private HashMap<Animal,Integer> animals = new HashMap<>();
    @Getter
    private List<Product> products = new ArrayList<>();

    public Farm(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                ", animals=" + animals +
                ", products=" + products +
                '}';
    }
}
