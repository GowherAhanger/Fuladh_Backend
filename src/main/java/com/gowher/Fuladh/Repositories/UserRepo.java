package com.gowher.Fuladh.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gowher.Fuladh.Models.User;

public interface UserRepo extends JpaRepository<User, Integer> {
    User findByNameAndPassword(String name, String password);

}
