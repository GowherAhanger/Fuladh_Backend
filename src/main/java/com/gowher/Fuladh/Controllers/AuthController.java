package com.gowher.Fuladh.Controllers;


import com.gowher.Fuladh.DTOs.RegisterDTO;
import com.gowher.Fuladh.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.gowher.Fuladh.DTOs.LoginDTO;
import com.gowher.Fuladh.Models.User;
import com.gowher.Fuladh.Utils.JwtUtil;

import java.util.Map;

@RestController
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    private UserService userService;

    private final AuthenticationManager authenticationManager;


    private JwtUtil jwtUtil;
    public AuthController(AuthenticationManager authenticationManager, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;

    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginDTO loginDTO)  {

        try {
            Authentication authentication =
                    authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginDTO.getEmailId(), loginDTO.getPassword()));
            String email = authentication.getName();
            User user = new User();
            user.setEmailId(email);
            String token = jwtUtil.generateToken(user);
            User userRes = new User();
            userRes.setEmailId(email);
            userRes.setToken(token);

            return ResponseEntity.ok(userRes);

        }catch (BadCredentialsException e){
            //ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST,"Invalid username or password");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("errorResponse1");
        }catch (Exception e){
            //ErrorRes errorResponse = new ErrorRes(HttpStatus.BAD_REQUEST, e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("errorResponse2");
        }
    }
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO dto) {
        User user = new User();
        user.setName(dto.getFullName());
        user.setEmailId(dto.getEmailId());
        user.setPassword(dto.getPassword());

        User savedUser = userService.addUser(user);

        return ResponseEntity.ok(Map.of(
                "message", "User registered successfully",
                "userId", savedUser.getId(),
                "email", savedUser.getEmailId()
        ));
    }

}
