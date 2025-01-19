package com.gowher.Fuladh.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowher.Fuladh.Models.Order;
import com.gowher.Fuladh.Repositories.OrederRepo;

@Service
public class OrderService {
    @Autowired
    private OrederRepo orederRepo;
    public List<Order> getOrders()
    {
        return orederRepo.findAll();
    }
}
