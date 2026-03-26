package com.farm.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Egg extends Product {
    private final String productName = "egg";
    private final double price = 1.5d;
}
