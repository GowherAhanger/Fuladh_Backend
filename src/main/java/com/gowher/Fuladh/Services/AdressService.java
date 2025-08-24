package com.gowher.Fuladh.Services;
import com.gowher.Fuladh.DTOs.AddressDTO;
import com.gowher.Fuladh.Models.Address;
import com.gowher.Fuladh.Repositories.AddressRepo;
import com.gowher.Fuladh.Repositories.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gowher.Fuladh.Models.User;

@Service
public class AdressService {
    @Autowired
    private AddressRepo addressRepo;
    @Autowired
    private UserRepo userRepo;

    public Address addAddress(AddressDTO dto) {
        User user=new User();
        Address savedAddress = new Address();
        try {
             user = userRepo.findById((int) dto.getUserId())
                    .orElseThrow(() -> new RuntimeException("User not found"));

        Address address = new Address();
        address.setAddressLine1(dto.getAddressLine1());
        address.setAddressLine2(dto.getAddressLine2());
        address.setCity(dto.getCity());
        address.setState(dto.getState());
        address.setPinCode(dto.getPinCode());
        address.setEmail(dto.getEmail());
        address.setUser(user);

        savedAddress = addressRepo.save(address);
        }
        catch(Exception e){
            System.out.println(e.getMessage());
        }
        return savedAddress;
    }

    public AddressDTO getAddressByUserId(long userId) {
        Address address = addressRepo.findByUserId(userId)
                .orElseThrow(() -> new RuntimeException("Address not found"));

        AddressDTO dto = new AddressDTO();
        dto.setId(address.getId());
        dto.setAddressLine1(address.getAddressLine1());
        dto.setAddressLine2(address.getAddressLine2());
        dto.setCity(address.getCity());
        dto.setState(address.getState());
        dto.setPinCode(address.getPinCode());
        dto.setEmail(address.getEmail());
        dto.setUserId(address.getUser().getId());

        return dto;
    }
}
