package com.gowher.Fuladh.Models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product_details")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String brand;
    private String longDescription;
    private Date mfdDate;
    private Date expDate;
    private int unit;
    private String size;
    private String color;

    // @JsonIgnore
    @OneToOne
    @JoinColumn(name = "product_id", nullable = false, unique = true)
    private Product product;
}
