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

    private Chicken ch = new Chicken();
    private Cow cw = new Cow();

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
            showAllAnimal();
        } else {
            System.out.println("В твоем хлеве уже есть животные...");
        }
    }

    //сбор урожая
    public void productAssembler(List<Animal> animals) {
        if (animals.isEmpty()) {
            System.out.println("У тебя нет животных");
        } else {
            animals.forEach(a -> products.addAll(a.produce()));
            System.out.println("Собираем продукты...");
            System.out.println("Ты собрал столько продуктов: ");
            showAllProduct();
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

    //Показывает всех животных
    public void showAllAnimal() {
        animals.stream().collect(Collectors.groupingBy(Animal::getClass, Collectors.counting())).forEach((key, value) -> System.out.printf("%d %s ", value, key.getSimpleName()));
        System.out.printf("%n");
    }
    //Покупка животных
    public void buyAnimals(Farm farm) {
        if (farm.getBalance() < 1) {
            System.out.println("У тебя не хватает денег на покупку животных");
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("Какое животное ты хочешь купить? У нас есть: ");
        getAnimalsPromptNames().forEach(n -> n.ifPresent(promptName -> System.out.print(promptName + ", ")));
        String aAn = scanner.nextLine();
        if (aAn.equalsIgnoreCase("курица")){
            System.out.println("Какое количество куриц ты хочешь купить?");
            int iAn = scanner.nextInt();
            //TODO Тут стоит придумать, как брать прайс у животных, пока как то так
            if (farm.getBalance()<ch.getPrice()*iAn){
                System.out.println("У тебя не хватает денег... Твой баланс: "+farm.getBalance()+" а цена за 1 курицу: "+ch.getPrice());
                buyAnimals(farm);
            }else{
                farm.setBalance(farm.getBalance()-ch.getPrice()*iAn);
                for (int i = 1; i <= iAn ; i++) {
                    animals.add(new Chicken());
                }
                System.out.println(iAn+" куриц добавилось к твоей ферме!");
                //TODO Та же проблема что и с коровой
//                System.out.println("Хочешь купить еще жвотных? Да/Нет");
//                String nw = scanner.nextLine();
//                if (nw.equalsIgnoreCase("да")){
//                    buyAnimals(farm);
//                }
            }
        } else if (aAn.equalsIgnoreCase("корова")) {
            System.out.println("Какое количество коров ты хочешь купить?");
            int iAn = scanner.nextInt();
            //TODO Тут стоит придумать, как брать прайс у животных, пока как то так
            if (farm.getBalance()<cw.getPrice()*iAn){
                System.out.println("У тебя не хватает денег... Твой баланс: "+farm.getBalance()+" а цена за 1 корову: "+cw.getPrice());
                buyAnimals(farm);
            }else{
                farm.setBalance(farm.getBalance()-cw.getPrice()*iAn);
                for (int i = 1; i <= iAn ; i++) {
                    animals.add(new Cow());
                }
                System.out.println("К твоим животным добавилось "+iAn+" коров");
                //TODO Хотел реализовать дополнительный выбор покупки животного, но почему то оно пропускалось в коде
//                System.out.println("Хочешь купить еще жвотных? Да/Нет");
//                String nw = scanner.nextLine();
//                if (nw.equalsIgnoreCase("да")){
//                    buyAnimals(farm);
//                }else{
//                    showAllAnimal();
//                }
            }
        }else{
            System.out.println("Такого животного как "+aAn+" нету");
            buyAnimals(farm);
        }
    }
}
