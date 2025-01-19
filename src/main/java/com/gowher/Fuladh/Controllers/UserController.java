package com.gowher.Fuladh.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.gowher.Fuladh.Models.User;
import com.gowher.Fuladh.Services.UserService;
//import com.gowher.Utils.JwtUtil;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/api")

public class UserController {
  @Autowired
  private UserService userService;

  @GetMapping("/getUsers")
  public List<User> getUsers() {
    return userService.getUsers();
  }

  //Add user works but goes to no go zone
  @PostMapping("/addUser")
  public User addUser(@RequestBody User user) {
     return userService.addUser(user);
  }

  @PutMapping("/updateUser")
  public User updateUser(@RequestParam int id,@RequestBody User user) {
      return userService.updateUser(id,user);
  }

  @DeleteMapping("/deleteUser")
  public User deletUser(@RequestParam int id) {
      return userService.deleteUser(id);
  }
  

}

