package com.gowher.Fuladh.Services;
import com.gowher.Fuladh.Models.Cart;
import com.gowher.Fuladh.Repositories.CartRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;

    public List<Cart> getCartItems()
    {
        return cartRepo.findAll();
    }

}
