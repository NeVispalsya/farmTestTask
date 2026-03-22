package com.farm.service;

import com.farm.dto.Farm;

import java.util.Scanner;

public class GameService {
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
        farmService.createFarmAnimals();
        System.out.println("Соберем продукты с твоих животных? Да/Нет");
        String a = scanner.nextLine();
        if (a.equalsIgnoreCase("да")) {
            farmService.productAssembler(farmService.getAnimals());
            System.out.println("Ты хочешь продать собранные продукты?");
            String saleAnswer = scanner.nextLine();
            if (saleAnswer.equalsIgnoreCase("да")) {
                farmService.saleProducts(farmService.getProducts(), farm);
                System.out.printf("Твой баланс - %s%n", farm.getBalance());
            }
            System.out.println("Готов купить новых животных для твоей фермы? Да/Нет");
            String buyAnswer = scanner.nextLine();
            if (buyAnswer.equalsIgnoreCase("да")) {
                farmService.buyAnimals(farm);
            }
            gameLate(farm,farmService);
        }
    }
    public void gameMidl(Farm farm, FarmService farmService){
        for (int i = 0; i < 7; i++) {
            farmService.productAssembler(farmService.getAnimals());
            System.out.println("Ты хочешь продать собранные продукты? Да/Нет");
            String saleAnswer = scanner.nextLine();
            if (saleAnswer.equalsIgnoreCase("да")) {
                farmService.saleProducts(farmService.getProducts(), farm);
                System.out.printf("Твой баланс - %s%n", farm.getBalance());
            }
            System.out.println("Готов купить новых животных для твоей фермы? Да/Нет");
            String buyAnswer = scanner.nextLine();
            if (buyAnswer.equalsIgnoreCase("да")) {
                farmService.buyAnimals(farm);
            }
        }
        gameEnd(farm,farmService);
    }
    public void gameLate(Farm farm, FarmService farmService){
        System.out.println("Ты хочешь ускоренно собирать урожай неделю?(7 дней)? Да/Нет");
        String weekAns = scanner.nextLine();
        if(weekAns.equalsIgnoreCase("да")){
            for (int i = 1; i <= 7; i++) {
                farmService.productAssembler(farmService.getAnimals());
            }
            gameEnd(farm,farmService);
        } else if (weekAns.equalsIgnoreCase("нет")){
            System.out.println("Тогда давай собирать вручную :3");
            gameMidl(farm,farmService);
        }
    }
    public void gameEnd(Farm farm, FarmService farmService){
        System.out.println("Прошла ровно неделя как ты собираешь и продаешь продукты с твоих любимых животных...");
        System.out.println("Давай подведем итоги");
        System.out.println("У тебя на ферме из животных");
        farmService.showAllAnimal();
        System.out.println("Продуктов у тебя");
        farmService.showAllProduct();
        System.out.println("Твой баланс: "+farm.getBalance());
        System.out.printf("До скорой встречи, %s!%n", farm.getName());
    }
}
