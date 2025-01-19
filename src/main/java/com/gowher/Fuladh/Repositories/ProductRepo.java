package com.gowher.Fuladh.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowher.Fuladh.Models.Product;

public interface ProductRepo extends JpaRepository<Product, Integer> {

}
