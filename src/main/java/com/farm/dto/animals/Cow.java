package com.farm.dto.animals;

import com.farm.dto.Animal;
//import com.farm.dto.Producer;
import com.farm.dto.Product;
import com.farm.dto.products.Milk;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@ToString(callSuper = true)
public class Cow extends Animal {

    private static final String[] NAMES = {
            "Зорька", "Бурёнка", "Ромашка", "Милка", "Дочка",
            "Звёздочка", "Малинка", "Красотка", "Пятнашка", "Дайна"
    };

    private final double price = 500d;

    public Cow() {
        super(NAMES, 8, 12);
    }

    @Override
    public Product createProduct() {
        return new Milk();
    }
}
