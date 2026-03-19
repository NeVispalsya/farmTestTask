package com.farm.dto.animals;

import com.farm.dto.Animal;
import com.farm.dto.Product;
import com.farm.dto.products.Egg;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
public class Chicken extends Animal {
    private static final String[] NAMES = {
            "Клокочка", "Пеструшка", "Рябушка", "Нёсушка", "Золотка",
            "Белочка", "Кудряшка", "Пуговка", "Зоряна"
    };

    private final double price = 20d;

    public Chicken() {
        super(NAMES, 0, 1);
    }

    @Override
    protected Product createProduct() {
        return new Egg();
    }
}
