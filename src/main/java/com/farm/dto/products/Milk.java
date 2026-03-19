package com.farm.dto.products;

import com.farm.dto.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
// Один класс отвечает за один литр молока
public class Milk extends Product {
    private final String productName = "milk";
    private final double price = 5d;
}
