package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Supplier;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends CrudRepository<Supplier, Integer> {

}
