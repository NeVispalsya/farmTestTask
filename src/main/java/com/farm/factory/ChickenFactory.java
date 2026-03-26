package com.farm.factory;

import com.farm.dto.Animal;
import com.farm.dto.Chicken;

public class ChickenFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Chicken();
    }

}
