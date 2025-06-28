package com.gowher.Fuladh.Services;
import com.gowher.Fuladh.Models.Cart;
import com.gowher.Fuladh.Models.CartItem;
import com.gowher.Fuladh.Models.Product;
import com.gowher.Fuladh.Models.User;
import com.gowher.Fuladh.Repositories.CartItemRepo;
import com.gowher.Fuladh.Repositories.CartRepo;
import com.gowher.Fuladh.Repositories.ProductRepo;
import com.gowher.Fuladh.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CartService {
    @Autowired
    private CartRepo cartRepo;
    @Autowired
    private CartItemRepo cartItemRepo;

    @Autowired
    private UserRepo userRepo;



    @Autowired
    private ProductRepo productRepo;

    public List<Cart> getCartItems()
    {
        return cartRepo.findAll();
    }



        public String addProductToCart(CartItem cartItem, int userId, int productId) {
            // Fetch user
            User user = userRepo.findById(userId)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Get or create cart
            Cart cart = cartRepo.findByUserId(userId);
            if (cart == null) {
                cart = new Cart();
                cart.setUser(user);
                cartRepo.save(cart);
            }

            // Fetch product
            Product product = productRepo.findById(productId)
                    .orElseThrow(() -> new RuntimeException("Product not found"));

            // Set references
            cartItem.setCart(cart);
            cartItem.setProduct(product);

            // Save to DB
            cartItemRepo.save(cartItem);

            return "Product added to cart";
        }
    }


