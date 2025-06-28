package com.gowher.Fuladh.Controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Services.ProductService;
import org.springframework.web.multipart.MultipartFile;


@RestController
@RequestMapping("/product")
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
//  @PostMapping("/addProduct")
//  public Product addProduct (@RequestBody Product product) {
//     return productService.addProduct(product);
//  }

    @PostMapping("/addProduct")
    public Product addProduct(
            @RequestParam("name") String name,
            @RequestParam("description") String description,
            @RequestParam("price") int price,
            @RequestParam("image") MultipartFile image
    ) throws IOException {
        // Create Product manually from params
        Product product = new Product();
        product.setName(name);
        product.setDescription(description);
        product.setPrice(price);

        return productService.save(product, image);
    }



}