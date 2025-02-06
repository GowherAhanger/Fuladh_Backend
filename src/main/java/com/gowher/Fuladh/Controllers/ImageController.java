package com.gowher.Fuladh.Controllers;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("/Image")
public class ImageController {

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("image") MultipartFile FILE) throws IOException {
        // Path where the image will be stored
        String uploadPath = "/home/gowher/Downloads/Fuladh_Backend/src/main/java/com/gowher/Fuladh/Images/";
    
        // Generate a unique file name
        String fileName = UUID.randomUUID().toString() + "_" + FILE.getOriginalFilename();
    
        // Upload the file
        File dest = new File(uploadPath + fileName);
    
        // Save the file
        FILE.transferTo(dest);
    
        // Return the image URL
        return "/uploads/" + fileName;
    }
    
}
