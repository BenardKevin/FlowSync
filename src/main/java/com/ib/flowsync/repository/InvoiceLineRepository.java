package com.ib.flowsync.repository;

import com.ib.flowsync.entity.InvoiceLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceLineRepository extends CrudRepository<InvoiceLine, Integer> {
}
