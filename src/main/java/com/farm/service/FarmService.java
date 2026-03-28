package com.farm.service;
import com.farm.dto.Animal;
import com.farm.dto.Farm;
import com.farm.dto.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FarmService {

    public void addAnimal(Farm farm, Animal animal, int amount){
        farm.getAnimals().merge(animal,amount,Integer::sum);
    }

    public List<Product> collectProducts(Farm farm) {
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
            return farm.getProducts();
        }
        return farm.getProducts();
    }

//    public List<Product> getAllProduct(Farm farm) {
////        farm.getProducts().stream().collect(Collectors.groupingBy(Product::getProductName, Collectors.counting())).forEach((key, value) -> System.out.printf("%d %s ", value, key));
////        System.out.printf("%n");
//        System.out.println(farm.getProducts());
//        return farm.getProducts();
//    }
}
