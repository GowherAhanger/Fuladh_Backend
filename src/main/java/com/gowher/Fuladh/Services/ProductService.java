package com.gowher.Fuladh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Repositories.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts()
    {
        return productRepo.findAll();
    }
 
    
}
