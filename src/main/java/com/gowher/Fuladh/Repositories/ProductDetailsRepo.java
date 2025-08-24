package com.gowher.Fuladh.Repositories;

import com.gowher.Fuladh.Models.ProductDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsRepo
    extends JpaRepository<ProductDetails, Integer> {
    ProductDetails findDetailsByProductId(int productId);
}
