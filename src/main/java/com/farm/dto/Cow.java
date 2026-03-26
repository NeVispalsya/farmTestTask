package com.farm.dto;

//import com.farm.dto.Producer;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Cow extends Animal {

    private static final String[] NAMES = {
            "Зорька", "Бурёнка", "Ромашка", "Милка", "Дочка",
            "Звёздочка", "Малинка", "Красотка", "Пятнашка", "Дайна"
    };

    private static final String promptName = "корова";


    public Cow() {
        super(NAMES, 8, 12);
    }

    @Override
    public Product createProduct() {
        return new Milk();
    }


}
