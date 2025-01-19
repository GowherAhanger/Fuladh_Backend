package com.gowher.Fuladh.Services;

import com.gowher.Fuladh.Models.User;
import com.gowher.Fuladh.Repositories.UserRepo;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestParam;

@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;

    public List<User> getUsers() {
        return userRepo.findAll();
    }

    public User addUser(User user) 
    {
        return userRepo.save(user);
    }

    public User updateUser(int id, User user) 
    {
        Optional <User> newUser = userRepo.findById(id);
        if (newUser.isPresent()) 
        {
            User oldUser = newUser.get();
            oldUser.setName(user.getName());
            oldUser.setEmailId(user.getEmailId());
            oldUser.setPassword(user.getPassword());
            //return userRepo.save(oldUser);

        }
        else{System.out.print("notPresent");}
                return user;
    }
    public User deleteUser(int id) {
        Optional<User> userToDelete = userRepo.findById(id);
        userRepo.deleteById(id);
        return new User();
    }
    
    
  
}

