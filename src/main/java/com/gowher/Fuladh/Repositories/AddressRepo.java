package com.gowher.Fuladh.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gowher.Fuladh.Models.Address;
import java.util.Optional;

public interface AddressRepo extends JpaRepository<Address, Integer> {
    Optional<Address> findByUserId(Long userId);
}
