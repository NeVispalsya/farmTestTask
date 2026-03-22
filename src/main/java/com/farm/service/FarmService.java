package com.farm.service;

import com.farm.dto.Animal;
import com.farm.dto.Farm;
import com.farm.dto.Product;
import com.farm.dto.animals.Chicken;
import com.farm.dto.animals.Cow;
import lombok.Getter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

public class FarmService {
    @Getter
    private List<Animal> animals = new ArrayList<>();
    @Getter
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "FarmService{" + "animals=" + animals + ", products=" + products + '}';
    }

    //Добавление перового количества коров и кур
    public void createFarmAnimals() {
        if (animals.isEmpty()) {
            System.out.println("Закупаем коров и куриц для твоего хлева...");
            for (int i = 0; i < 10; i++) {
                animals.add(new Cow());
                animals.add(new Chicken());
                animals.add(new Chicken());
            }
        } else {
            System.out.println("В твоем хлеве уже есть животные...");
        }
    }

    //сбор урожая
    public void productAssembler(List<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("У тебя нет животных");
        } else {
//            for (Animal animal : animals) {
//                products.addAll(animal.produce());
//            }
            animals.forEach(a -> products.addAll(a.produce()));
            System.out.println("Собираем продукты...");
        }
    }

    //продажа урожая
    public void saleProducts(List<Product> products, Farm farm) {
        if (products.isEmpty()) {
            System.out.println("У тебя нет продуктов чтобы продать");
        } else {
            double money = farm.getBalance();
            for (Product product : products) {
                money += product.getPrice();
            }
            farm.setBalance(money);
        }
    }

    //Показывает все продукты
    public void showAllProduct() {
//         for(Product product : products){
//            System.out.print(product.getProductName()+" ");
//        }
        products.stream().collect(Collectors.groupingBy(Product::getProductName, Collectors.counting())).forEach((key, value) -> System.out.printf("%d %s ", value, key));
        System.out.printf("%n");

    }

    private List<Optional<String>> getAnimalsPromptNames() {
        return Animal.getInstantiatedDerivedTypes().stream().map(type -> {
            try {
                Field field = type.getDeclaredField("promptName");
                field.setAccessible(true);
                return Optional.ofNullable((String) field.get(null));

            } catch (NoSuchFieldException | IllegalAccessException e) {
                System.out.printf("класс %s не имеет доступного имени ", type.getSimpleName());
                return Optional.<String>empty();
            }
        }).collect(Collectors.toList());
    }


    ;

    //Показывает всех животных
    public void showAllAnimal() {
//        for (Animal animal : animals) {
//            System.out.print(animal.getName() + " ");
//        }
        animals.stream().collect(Collectors.groupingBy(Animal::getClass, Collectors.counting())).forEach((key, value) -> System.out.printf("%d %s ", value, key.getSimpleName()));
        // Это для того чтобы не слипалось в одну строку
        System.out.printf("%n");


    }

    public void buyAnimals(Farm farm, int anim, Scanner sc) {
//        if (farm.getBalance() < 20) {
//            System.out.println("У тебя не хватает денег на покупку животных");
//        }
        if (farm.getBalance() < 1) {
            System.out.println("У тебя не хватает денег на покупку животных");
        }

        System.out.println("Какое животное ты хочешь купить?");
        System.out.print("У нас есть: ");
        getAnimalsPromptNames().forEach(n -> n.ifPresent(promptName -> System.out.print(promptName + ", ")));
//        if (sc.nextLine()) {
//
//        }

    }
}
