package com.gowher.Fuladh.Controllers;

import com.gowher.Fuladh.DTOs.AddressDTO;
import com.gowher.Fuladh.Models.Address;
import com.gowher.Fuladh.Services.AdressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/address")
public class AdressController {
    @Autowired
    private AdressService adressService;

    @PostMapping("/addAddress")
    public Address addAddress(@RequestBody AddressDTO address) {
        return adressService.addAddress(address);
    }

    @GetMapping("/getAddressById")
    public AddressDTO getAddressByUserId(@RequestParam long userId) {
        return adressService.getAddressByUserId(userId);
    }
}
