package com.ib.flowsync.repository;

import com.ib.flowsync.entity.Contact;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer> {

    Iterable<Contact> findByFirstname(String firstname);
}
