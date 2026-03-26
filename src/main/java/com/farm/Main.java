package com.farm;

import com.farm.dto.Farm;
import com.farm.service.FarmService;
import com.farm.service.GameService;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Farm simulator 2026");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter your name:");
        String name = scanner.nextLine();
        Farm farm = new Farm(name);
        FarmService farmService = new FarmService();
        GameService gameService = new GameService();
        System.out.printf("Welcome to your farm %s!%n", farm.getName());
        System.out.println("Ready to buy your first animals for your farm? Yes/No");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("yes")) {
                gameService.gameStart(farm,farmService);
        } else {
            System.out.printf("See you soon, %s!%n", farm.getName());
        }
    }
}