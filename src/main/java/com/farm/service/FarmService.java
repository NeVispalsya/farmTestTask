package com.farm.service;
import com.farm.dto.Animal;
import com.farm.dto.Farm;
import com.farm.dto.Product;
import com.farm.dto.Chicken;
import com.farm.dto.Cow;
import com.farm.factory.ChickenFactory;
import com.farm.factory.CowFactory;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FarmService {
    CowFactory cowFactory;
    ChickenFactory chickenFactory;


    public void addAnimal(Farm farm, Animal animal, int amount){
        farm.getAnimals().merge(animal,amount,Integer::sum);
    }

    //сбор урожая
    public List<Product> productAssembler(Farm farm) {
        if (farm.getAnimals().isEmpty()) {
            System.out.println("You don't have animals");
        } else {
            for (Map.Entry<Animal, Integer> entry : farm.getAnimals().entrySet()){
                Animal animal = entry.getKey();
                int count = entry.getValue();
                for (int i = 0; i < count; i++) {
                    farm.getProducts().add(animal.createProduct());
                }
            }
            System.out.println("We are collecting food...");
            System.out.println("You have collected so many products: ");
            System.out.println(getAllProduct(farm));
            return farm.getProducts();
        }
        return farm.getProducts();
    }

    //Показывает все продукты
    public List<Product> getAllProduct(Farm farm) {
        farm.getProducts().stream().collect(Collectors.groupingBy(Product::getProductName, Collectors.counting())).forEach((key, value) -> System.out.printf("%d %s ", value, key));
        System.out.printf("%n");
        return farm.getProducts();
    }
}
