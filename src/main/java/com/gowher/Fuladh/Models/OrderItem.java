package com.gowher.Fuladh.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;

//import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "OrderItem")
public class OrderItem {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private int productId;
   private int quantity;
   @JsonIgnore
   @ManyToOne
   @JoinColumn(name="order_id")
   private Order order;
}
