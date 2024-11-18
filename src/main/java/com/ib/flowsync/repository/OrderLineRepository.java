package com.ib.flowsync.repository;

import com.ib.flowsync.entity.OrderLine;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderLineRepository extends CrudRepository<OrderLine, Integer> {
}
