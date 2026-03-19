package com.farm.dto.animals;

import com.farm.dto.Animal;
import com.farm.dto.Producer;
import com.farm.dto.Product;
import com.farm.dto.products.Milk;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
public class Cow extends Animal {

    private static final String[] NAMES = {
            "Зорька", "Бурёнка", "Ромашка", "Милка", "Дочка",
            "Звёздочка", "Малинка", "Красотка", "Пятнашка", "Дайна"
    };

    private static final int minProduct = 8;
    private static final int maxProduct = 12;

    private UUID id;
    private String name;
    private final double price = 500d;

    public Cow() {
        super(NAMES);
    }


    @Override
    protected Product createProduct() {
        return new Milk();
    }
}
