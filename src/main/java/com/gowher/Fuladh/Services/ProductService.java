package com.gowher.Fuladh.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Repositories.ProductRepo;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;

    public List<Product> getProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(int id) {
        return productRepo.findById(id);
    }

    public Optional<Product> updateProduct(int id, Product product) {
        Optional<Product> productToUpdate = productRepo.findById(id);

        if (productToUpdate.isPresent()) {
            Product existingProduct = productToUpdate.get();
            existingProduct.setName(product.getName());
            existingProduct.setDiscription(product.getDiscription());
            existingProduct.setPrice(product.getPrice());
            productRepo.save(existingProduct);
            return Optional.of(existingProduct);
        }

        System.out.println("Update Failed");
        return Optional.empty();
    }

    public Optional<Product> deleteProduct(int id) {
        Optional<Product> productToDelete = productRepo.findById(id);

        if (productToDelete.isPresent()) {
            productRepo.deleteById(id);
            return productToDelete;
        }

        System.out.println("Product with ID " + id + " not found.");
        return Optional.empty();
    }

    public Product addProduct(Product product) {
       return productRepo.save(product);
    }

}