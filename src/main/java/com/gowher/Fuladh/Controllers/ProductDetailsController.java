package com.gowher.Fuladh.Controllers;

import com.gowher.Fuladh.Models.ProductDetails;
import com.gowher.Fuladh.Services.ProductDetailsService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/productDetails")
public class ProductDetailsController {

    @Autowired
    private ProductDetailsService productDetailsService;

    @GetMapping("/getProductDetails")
    public ProductDetails getProductDetails(@RequestParam int productId) {
        try {
            return productDetailsService.getProductDetailsByProductId(
                productId
            );
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
