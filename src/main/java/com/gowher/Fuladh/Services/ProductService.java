package com.gowher.Fuladh.Services;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Repositories.ProductRepo;
import org.springframework.web.multipart.MultipartFile;

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
            existingProduct.setDescription(product.getDescription());
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
    //....................................................................................


//    @Value("${file.upload-dir}")
//    private String uploadDir;
//
//    public Product save(Product product, MultipartFile imageFile) {
//        try {
//            String fileName = UploadImage(imageFile);
//            // Set image URL
//            product.setImageUrl("/images/" + fileName);
//
//            // Save to DB
//            return productRepo.save(product);
//
//        } catch (IOException e) {
//            throw new RuntimeException("Image upload failed: " + e.getMessage());
//        }
//
//    }
//
//    public String UploadImage(MultipartFile imageFile) throws IOException {
//        String fileName = "";
//        try {
//            // Create folder if it doesn't exist
//            File directory = new File(uploadDir);
//            if (!directory.exists()) {
//                directory.mkdirs();
//            }
//
//            // Generate unique file name
//            fileName = imageFile.getOriginalFilename();
//
//            // Full file path
//            File destination = new File(uploadDir + fileName);
//
//            // Save image
//            imageFile.transferTo(destination);
//        }catch(Exception e){
//            System.out.println(e.getMessage());
//        }
//        return fileName;
//    }
// Remove @Value injection since we're hardcoding the path now
private final String uploadDir = "/home/gowher/Downloads/Fuladh_Backend/src/main/resources/static/images/";

    public Product save(Product product, MultipartFile imageFile) {
        try {
            String fileName = UploadImage(imageFile);
            // Set image URL - You can update this if your frontend needs the full path
            product.setImageUrl("images/" + fileName);

            // Save to DB
            return productRepo.save(product);
        } catch (IOException e) {
            throw new RuntimeException("Image upload failed: " + e.getMessage());
        }
    }

    public String UploadImage(MultipartFile imageFile) throws IOException {
        String fileName = "";
        try {
            // Create folder if it doesn't exist
            File directory = new File(uploadDir);
            if (!directory.exists()) {
                directory.mkdirs();
            }

            // Generate unique file name
            fileName = imageFile.getOriginalFilename();

            // Full file path
            File destination = new File(uploadDir + fileName);

            // Save image
            imageFile.transferTo(destination);
        } catch (Exception e) {
            System.out.println("File upload error: " + e.getMessage());
        }

        return fileName;
    }


}




