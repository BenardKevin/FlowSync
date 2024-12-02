package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Address;
import com.ib.flowsync.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/addresses")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class AddressController {

    @Autowired
    AddressService addressService;

    @PostMapping("")
    public ResponseEntity<String> createAddress(
            @RequestBody Address address
    ) {
        addressService.createAddress(address);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Address creation was successful");
    }

    @GetMapping("")
    public List<Address> getAllAddress() {
        return addressService.getAllAddress();
    }

    @GetMapping("/{addressId}")
    public @ResponseBody Address getAddressById(
            @PathVariable(value = "addressId") Integer addressId
    ) throws ResponseStatusException {
        Address address = addressService.getAddressById(addressId);

        if(address == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "address not found");

        return address;
    }

    @PutMapping("/{addressId}")
    public ResponseEntity<String> updateAddress(
            @PathVariable(value = "addressId") Integer addressId,
            @RequestBody Address address
    ) {
        addressService.updateAddress(address, addressId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Address update was successful");
    }

    @DeleteMapping("/{addressId}")
    public @ResponseBody void deleteAddress(
            @PathVariable(value = "addressId") Integer addressId
    ) {
        addressService.deleteAddress(addressId);
    }
}
