package com.gowher.Fuladh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowher.Fuladh.Models.Cart;
import com.gowher.Fuladh.Services.CartService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    
    @GetMapping("/getCartItems")
    public List<Cart> getCartItems() {
        return cartService.getCartItems();
    }

}
