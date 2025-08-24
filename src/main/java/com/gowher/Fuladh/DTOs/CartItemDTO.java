package com.gowher.Fuladh.DTOs;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItemDTO {
    private int id;
    private long productId;
    private String productName;
    private double price;
    private int quantity;
    private String imageUrl;
}
