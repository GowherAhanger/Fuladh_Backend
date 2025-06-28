package com.gowher.Fuladh.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "CartItem")

public class CartItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private int quantity;
   @JsonIgnore
    @ManyToOne
    @JoinColumn(name="cart_id")
   private Cart cart;
   @JsonIgnore
   @ManyToOne
   @JoinColumn(name = "product_id", nullable = false)
    private Product product;

}
