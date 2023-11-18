package com.apewithglasses.pizza.services.dto;

import lombok.Data;

@Data
public class UpdatePizzaPriceDTO {
    private int pizzaId;
    private double price;
}
