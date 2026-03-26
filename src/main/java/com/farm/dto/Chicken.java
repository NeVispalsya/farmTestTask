package com.farm.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Chicken extends Animal {
    private static final String[] NAMES = {
            "Клокочка", "Пеструшка", "Рябушка", "Нёсушка", "Золотка",
            "Белочка", "Кудряшка", "Пуговка", "Зоряна"
    };
    private static final String promptName = "курица";


    public Chicken() {
        super(NAMES, 0, 1);
    }

    @Override
    public Product createProduct() {
        return new Egg();
    }


}
