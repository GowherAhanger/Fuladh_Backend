package com.gowher.Fuladh.Services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gowher.Fuladh.Models.Category;
import com.gowher.Fuladh.Repositories.CatagoryReppo;

@Service
public class CatagoryService {
    @Autowired
    private CatagoryReppo catagoryReppo;

    public List<Category> getCategory() {
        return catagoryReppo.findAll();
    }
}
