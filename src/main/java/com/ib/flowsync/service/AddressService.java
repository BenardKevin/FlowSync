package com.ib.flowsync.service;

import com.ib.flowsync.entity.Address;
import com.ib.flowsync.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    @Autowired
    private AddressRepository addressRepository;

    public void createAddress(Address address) {
        address.setId(null);
        addressRepository.save(address);
    }

    public List<Address> getAllAddress() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address getAddressById(Integer addressId) {
        return addressRepository.findById(addressId).orElse(null);
    }

    public void updateAddress(Address address, Integer addressId) {
        address.setId(addressId);
        addressRepository.save(address);
    }

    public void deleteAddress(Integer addressId) {
        addressRepository.deleteById(addressId);
    }
}
