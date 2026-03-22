package com.farm;

import com.farm.dto.Farm;
import com.farm.service.FarmService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Farm simulator 2026");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Напиши свое имя:");
        String name = scanner.nextLine();

        Farm farm = new Farm(name);
        FarmService farmService = new FarmService();
        System.out.println(String.format("Добро пожаловать на твою ферму %s!", farm.getName()));
        System.out.println("Готов купить своих первых животных для твоей фермы? Да/Нет");
        String answer = scanner.nextLine();
        boolean game;
        if (answer.toLowerCase().equals("да")) {
            game = true;
            do {
                System.out.println("------------------------");
                System.out.println("█████  ████  ████  █   █");
                System.out.println("█      █  █  █  █  ██ ██");
                System.out.println("████   ████  ████  █ █ █");
                System.out.println("█      █  █  █ █   █   █");
                System.out.println("█      █  █  █  █  █   █");
                System.out.println("------------------------");
                System.out.println();
                farmService.createFarmAnimals();
                farmService.showAllAnimal();
                System.out.println("Соберем продукты с твоих животных? Да/Нет");
                String a = scanner.nextLine();
                if (a.toLowerCase().equals("да")) {
                    farmService.productAssembler(farmService.getAnimals());
                    System.out.println("Ты собрал столько продуктов: ");
                    farmService.showAllProduct();

                    System.out.println("Ты хочешь продать собранные продукты?");
                    String saleAnswer = scanner.nextLine();

                    if (saleAnswer.equalsIgnoreCase("да")) {
                        farmService.saleProdect(farmService.getProducts(), farm);
                        System.out.printf("Твой обновленный баланс - %s", farm.getBalance());
                    }

                    //Заглушка чтобы защититься от бесконечного цикла
                    game = false;

                } else {
                    game = false;
                }


            } while (game);

        } else {
            game = false;
            System.out.println(String.format("До скорой всетречи, %s!", farm.getName()));
        }

    }
}