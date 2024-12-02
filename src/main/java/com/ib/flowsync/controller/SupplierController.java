package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Supplier;
import com.ib.flowsync.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/suppliers")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class SupplierController {

    @Autowired
    SupplierService supplierService;

    @PostMapping("")
    public ResponseEntity<String> createSupplier(
            @RequestBody Supplier supplier
    ) {
        supplierService.createSupplier(supplier);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Supplier creation was successful");
    }

    @GetMapping("")
    public List<Supplier> getAllSupplier() {
        return supplierService.getAllSupplier();
    }

    @GetMapping("/{supplierId}")
    public @ResponseBody Supplier getSupplierById(
            @PathVariable(value = "supplierId") Integer supplierId
    ) throws ResponseStatusException {
        Supplier supplier = supplierService.getSupplierById(supplierId);

        if(supplier == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "supplier not found");

        return supplier;
    }

    @PutMapping("/{supplierId}")
    public ResponseEntity<String> updateSupplier(
            @PathVariable(value = "supplierId") Integer supplierId,
            @RequestBody Supplier supplier
    ) {
        supplierService.updateSupplier(supplier, supplierId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Supplier update was successful");
    }

    @DeleteMapping("/{supplierId}")
    public @ResponseBody void deleteSupplier(
            @PathVariable(value = "supplierId") Integer supplierId
    ) {
        supplierService.deleteSupplier(supplierId);
    }
}
