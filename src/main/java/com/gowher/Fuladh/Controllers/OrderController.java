
package com.gowher.Fuladh.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowher.Fuladh.Models.Order;
import com.gowher.Fuladh.Services.OrderService;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService ordersService;

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return ordersService.getOrders();
    }

}
