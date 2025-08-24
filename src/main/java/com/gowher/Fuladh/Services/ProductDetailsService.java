package com.gowher.Fuladh.Services;

import com.gowher.Fuladh.Models.ProductDetails;
import com.gowher.Fuladh.Repositories.ProductDetailsRepo;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductDetailsService {

    @Autowired
    private ProductDetailsRepo productDetailsRepo;

    public ProductDetails getProductDetailsByProductId(int productId) {
        try {
            ProductDetails obj = productDetailsRepo.findDetailsByProductId(
                productId
            );
            return obj;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
