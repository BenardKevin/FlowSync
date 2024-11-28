package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Privilege;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PrivilegeRepository extends CrudRepository<Privilege, Integer> {

    public Optional<Privilege> findByName(String name);
}
