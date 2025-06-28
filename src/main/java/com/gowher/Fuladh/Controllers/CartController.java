package com.gowher.Fuladh.Controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.gowher.Fuladh.Models.CartItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
//    @PostMapping("/addToCart")
//    public String addToCart(
//            @RequestBody CartItem cartItem,
//            @RequestParam int userId,
//            @RequestParam int productId) {
//        return cartService.addProductToCart(cartItem, userId, productId);
//    }
@PostMapping("/addToCart")
public ResponseEntity<Map<String, String>> addToCart(
        @RequestBody CartItem cartItem,
        @RequestParam int userId,
        @RequestParam int productId) {

    cartService.addProductToCart(cartItem, userId, productId);

    Map<String, String> response = new HashMap<>();
    response.put("message", "Product added to cart");

    return ResponseEntity.ok(response);
}

}

