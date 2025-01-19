package com.gowher.Fuladh.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gowher.Fuladh.Models.Category;

@Repository
public interface CatagoryReppo extends JpaRepository<Category, Integer> {

}
