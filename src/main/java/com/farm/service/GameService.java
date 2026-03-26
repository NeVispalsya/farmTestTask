package com.farm.service;

import com.farm.dto.Farm;
import com.farm.factory.ChickenFactory;
import com.farm.factory.CowFactory;

import java.util.Scanner;

public class GameService {
    ChickenFactory chickenFactory = new ChickenFactory();
    CowFactory cowFactory = new CowFactory();
    BuyService buyService = new BuyService();
    FarmService farmService = new FarmService();
    Scanner scanner = new Scanner(System.in);
    public void gameStart(Farm farm, FarmService farmService){
        System.out.println("------------------------");
        System.out.println("█████  ████  ████  █   █");
        System.out.println("█      █  █  █  █  ██ ██");
        System.out.println("████   ████  ████  █ █ █");
        System.out.println("█      █  █  █ █   █   █");
        System.out.println("█      █  █  █  █  █   █");
        System.out.println("------------------------");
        System.out.println();
        if (farm.getAnimals().isEmpty()) {
            System.out.println("We are purchasing 10 cows and 20 chickens for your barn...");
            farmService.addAnimal(farm,cowFactory.createAnimal(),10);
            farmService.addAnimal(farm,chickenFactory.createAnimal(),20);
            System.out.println("You have such animals: "+farm.getAnimals().entrySet());
        } else {
            System.out.println("There are already animals in your barn...");
        }
        System.out.println("Should we collect food from your animals? Yes/No");
        String a = scanner.nextLine();
        if (a.equalsIgnoreCase("yes")) {
            farmService.productAssembler(farm);
            System.out.println("Do you want to sell the products you've collected? Yes/No");
            String saleAnswer = scanner.nextLine();
            if (saleAnswer.equalsIgnoreCase("yes")) {
                buyService.saleProducts(farm);
                System.out.printf("Your balance - %s%n", farm.getBalance());
            }
            System.out.println("Ready to buy new animals for your farm? Yes/No");
            String buyAnswer = scanner.nextLine();
            if (buyAnswer.equalsIgnoreCase("yes")) {
                buyService.buyAnimal(farm);
            }
            gameLate(farm,farmService,buyService);
        }
    }
    public void gameMidl(Farm farm, FarmService farmService, BuyService buyService){
        for (int i = 0; i < 7; i++) {
            farmService.productAssembler(farm);
            System.out.println("Do you want to sell the products you've collected? Yes/No");
            String saleAnswer = scanner.nextLine();
            if (saleAnswer.equalsIgnoreCase("yes")) {
                buyService.saleProducts(farm);
                System.out.printf("Your balance - %s%n", farm.getBalance());
            }
            System.out.println("Ready to buy new animals for your farm? Yes/No");
            String buyAnswer = scanner.nextLine();
            if (buyAnswer.equalsIgnoreCase("yes")) {
                buyService.buyAnimal(farm);
            }
        }
        gameEnd(farm,farmService);
    }
    public void gameLate(Farm farm, FarmService farmService,BuyService buyService){
        System.out.println("Do you want to harvest quickly in a week (7 days)? Yes/No");
        String weekAns = scanner.nextLine();
        if(weekAns.equalsIgnoreCase("yes")){
            for (int i = 1; i <= 7; i++) {
                farmService.productAssembler(farm);
            }
            gameEnd(farm,farmService);
        } else if (weekAns.equalsIgnoreCase("no")){
            System.out.println("Then let's assemble it manually :3");
            gameMidl(farm,farmService,buyService);
        }
    }
    public void gameEnd(Farm farm, FarmService farmService){
        System.out.println("It's been exactly a week since you've been collecting and selling products from your favorite animals...");
        System.out.println("Let's sum it up");
        System.out.println("You have animals on your farm \n"+farm.getAnimals());
        System.out.println("Products you have \n"+farm.getProducts());
        System.out.println("Your balance: "+farm.getBalance());
        System.out.printf("See you soon, %s!%n", farm.getName());
    }
}
