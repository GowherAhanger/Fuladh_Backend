package com.gowher.Fuladh.Controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gowher.Fuladh.Models.Category;
import com.gowher.Fuladh.Services.CatagoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CatagoryService catagoryService;

    @GetMapping("/getCategory")
    public List<Category> getCategory() {
        return catagoryService.getCategory();
    }

}
