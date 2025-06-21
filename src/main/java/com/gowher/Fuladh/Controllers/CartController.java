package com.gowher.Fuladh.Controllers;

import java.util.List;

import com.gowher.Fuladh.Models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.gowher.Fuladh.Models.Cart;
import com.gowher.Fuladh.Services.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {
    @Autowired
    private CartService cartService;
    
    @GetMapping("/getCartItems")
    public List<Cart> getCartItems() {
        return cartService.getCartItems();
    }
    @PostMapping("/addToCart")
    public String addToCart(
            @RequestBody CartItem cartItem,
            @RequestParam int userId,
            @RequestParam int productId) {
        return cartService.addProductToCart(cartItem, userId, productId);
    }
}

