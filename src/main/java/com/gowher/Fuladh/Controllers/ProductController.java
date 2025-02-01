package com.gowher.Fuladh.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Services.ProductService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PostMapping;


@RestController
@RequestMapping("/api")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/getProducts")
    public List<Product> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/getProductById")
    public Optional<Product> getProductById(@RequestParam int id) {
        return productService.getProductById(id);
    }

    @PutMapping("/updateProduct")
    public Optional<Product> updateProduct(@RequestParam int id, @RequestBody Product product) {
        return productService.updateProduct(id, product);
    }

    @DeleteMapping("/deleteProduct")
  public Optional<Product> deleteProduct(@RequestParam int id)
  {
      return productService.deleteProduct(id);
    
  }
  @PostMapping("/addProduct")
  public Product addProduct (@RequestBody Product product) {
     return productService.addProduct(product);
  }
  



}