package com.ch07.DTO;

import lombok.Data;

@Data
public class ProductAggDTO {
    private int priceSum;
    private double priceAvg;
    private int priceMax;
    private int priceMin;
}
