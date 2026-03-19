package com.farm.dto.animals;

import com.farm.dto.Animal;
import com.farm.dto.Product;
import com.farm.dto.products.Egg;
import lombok.Getter;
import lombok.Setter;


import java.util.UUID;

@Getter
@Setter
public class Chicken extends Animal {
    private static final String[] NAMES = {
            "Клокочка", "Пеструшка", "Рябушка", "Нёсушка", "Золотка",
            "Белочка", "Кудряшка", "Пуговка", "Зоряна"
    };

    private static final int minProduct = 0;
    private static final int maxProduct = 1;

    private UUID id;
    private String name;
    private final double price = 20d;

    public Chicken() {
        super(NAMES);
    }


    @Override
    protected Product createProduct() {
        return new Egg();
    }
}
