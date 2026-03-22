package com.farm;

import com.farm.dto.Farm;
import com.farm.service.FarmService;
import com.farm.service.GameService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Farm simulator 2026");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Напиши свое имя:");
        String name = scanner.nextLine();
        Farm farm = new Farm(name);
        FarmService farmService = new FarmService();
        GameService gameService = new GameService();
        System.out.printf("Добро пожаловать на твою ферму %s!%n", farm.getName());
        System.out.println("Готов купить своих первых животных для твоей фермы? Да/Нет");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("да")) {
                gameService.gameStart(farm,farmService);
        } else {
            System.out.printf("До скорой встречи, %s!%n", farm.getName());
        }
    }
}