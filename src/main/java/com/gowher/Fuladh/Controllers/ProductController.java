package com.gowher.Fuladh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Services.ProductService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

}
