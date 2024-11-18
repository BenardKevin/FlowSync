package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Contact;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Optional<Contact> findByName(String name);
}
