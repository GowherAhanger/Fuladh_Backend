package com.gowher.Fuladh.Repositories;

import com.gowher.Fuladh.Models.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepo extends JpaRepository<Cart, Integer> {

    Cart findByUserId(int userId);
}
