package com.farm.service;

import com.farm.dto.Animal;
import com.farm.dto.Product;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PrintService {
    public void print(HashMap<Animal, Integer> animals) {
        animals.forEach((key, value) -> System.out.printf("%d %s%n", value, key.getClass().getSimpleName().toLowerCase()));
    }

    public void print(List<Product> products) {
        products.stream().collect(Collectors.groupingBy(Product::getProductName, Collectors.counting()))
                .forEach((key, value) -> System.out.printf("%d %s%n", value, key));
    }
}
