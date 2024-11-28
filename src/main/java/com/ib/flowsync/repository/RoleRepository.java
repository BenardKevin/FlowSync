package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Contact;
import com.ib.flowsync.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Integer> {

    public Optional<Role> findByName(String name);
}
