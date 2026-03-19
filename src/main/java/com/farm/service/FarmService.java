package com.farm.service;
import com.farm.dto.Animal;
import com.farm.dto.Farm;
import com.farm.dto.Product;
import com.farm.dto.animals.Chicken;
import com.farm.dto.animals.Cow;
import lombok.Getter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

public class FarmService {
    @Getter
    private List<Animal> animals = new ArrayList<>();
    @Getter
    private List<Product> products = new ArrayList<>();

    @Override
    public String toString() {
        return "FarmService{" +
                "animals=" + animals +
                ", products=" + products +
                '}';
    }

    public void createFarmAnimals(){
        if(animals.isEmpty()){
            System.out.println("Закупаем коров и куриц для твоего хлева...");
            for (int i = 0; i < 10; i++) {
                animals.add(new Cow());
                for (int j = 0; j < 20; j++) {
                    animals.add(new Chicken());
                }
            }
        }else{
            System.out.println("В твоем хлеве уже есть животные...");
        }
    }

    public void productAssembler(List<Animal> animals){
        if (animals.isEmpty()){
            System.out.println("У тебя нет животных");
        }else{
            //animals.forEach(animal -> products.add((Product) animal.produce()));
            for(Animal animal : animals){
                products.add(animal.produce());
            }
            System.out.println("Собираем продукты...");
        }
    }

    public void saleProdect(List<Product> products,Farm farm){
        if (products.isEmpty()){
            System.out.println("У тебя нет продуктов чтобы продать");
        }else{
            double money=farm.getBalance();
            for(Product product : products){
                money+=product.getPrice();
            }
            farm.setBalance(money);
        }
    }
//    public List<Animal> buyAnimals(Farm farm,int anim){
//        if(farm.getBalance()<20){
//            System.out.println("У тебя не хватает денег на покупку животных");
//        }
//
//    }
}
