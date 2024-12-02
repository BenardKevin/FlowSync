package com.ib.flowsync.service;

import com.ib.flowsync.entity.Supplier;
import com.ib.flowsync.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    @Autowired
    private SupplierRepository supplierRepository;

    public void createSupplier(Supplier supplier) {
        supplier.setId(null);
        supplierRepository.save(supplier);
    }

    public List<Supplier> getAllSupplier() {
        return (List<Supplier>) supplierRepository.findAll();
    }

    public Supplier getSupplierById(Integer supplierId) {
        return supplierRepository.findById(supplierId).orElse(null);
    }

    public void updateSupplier(Supplier supplier, Integer supplierId) {
        supplier.setId(supplierId);
        supplierRepository.save(supplier);
    }

    public void deleteSupplier(Integer supplierId) {
        supplierRepository.deleteById(supplierId);
    }
}
