package com.farm.service;

import com.farm.dto.Farm;
import com.farm.dto.Product;
import com.farm.factory.ChickenFactory;
import com.farm.factory.CowFactory;

import java.util.Scanner;
import java.util.stream.Collectors;


public class BuyService {
   private final CowFactory cowFactory;
   private final ChickenFactory chickenFactory;
   private final FarmService farmService;

    public BuyService(CowFactory cowFactory, ChickenFactory chickenFactory, FarmService farmService) {
        this.cowFactory = cowFactory;
        this.chickenFactory = chickenFactory;
        this.farmService = farmService;
    }

    public void buyAnimal(Farm farm){
        String availableTypes = farm.getAnimals().keySet().stream()
                .map(animal -> animal.getClass().getSimpleName())
                .distinct()
                .collect(Collectors.joining(", "));
        Scanner scanner = new Scanner(System.in);
        System.out.print("What kind of animal do you want to buy? We have: "+availableTypes);
        String answ = scanner.nextLine();
        if(answ.equalsIgnoreCase("chicken")){
            Scanner sc = new Scanner(System.in);
            System.out.println("How many chicken's do you want to buy?");
            int am=sc.nextInt();
            if(pay(farm,10*am)){
                farmService.addAnimal(farm,chickenFactory.createAnimal(),am);
                System.out.println("We've added "+am+" chicken's to your farm");
            }
        } else if (answ.equalsIgnoreCase("cow")) {
            Scanner sc = new Scanner(System.in);
            System.out.println("How many cow's do you want to buy?");
            int am=sc.nextInt();
            if(pay(farm,50*am)){
                farmService.addAnimal(farm,cowFactory.createAnimal(),am);
                System.out.println("We've added "+am+" cow's to your farm");
            }
        }
    }

    public boolean pay(Farm farm, double price){
        if (price>farm.getBalance()){
            System.out.println("You don't have enough money to pay... Your balance: "+farm.getBalance());
            return false;
        }else{
            farm.setBalance(farm.getBalance()-price);
            return true;
        }
    }

    public void saleProducts(Farm farm){
        if (farm.getProducts().isEmpty()) {
            System.out.println("You don't have any products to sell...");
        } else {
            double money = farm.getBalance();
            for (Product product : farm.getProducts()) {
                money += product.getPrice();
            }
            farm.setBalance(money);
            farm.getProducts().clear();
        }
    }
}
