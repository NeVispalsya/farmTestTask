package com.farm.dto;

public class Farm {
    private String name;
    private double balance;

    public Farm(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Farm{" +
                "name='" + name + '\'' +
                ", balance=" + balance +
                '}';
    }

}
