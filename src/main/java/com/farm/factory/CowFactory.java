package com.farm.factory;

import com.farm.dto.Animal;
import com.farm.dto.Cow;

public class CowFactory extends AnimalFactory{
    @Override
    public Animal createAnimal() {
        return new Cow();
    }

}
