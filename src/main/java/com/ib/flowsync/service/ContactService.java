package com.ib.flowsync.service;

import com.ib.flowsync.entity.Contact;
import com.ib.flowsync.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactService {

    @Autowired
    private ContactRepository contactRepository;

    public void createContact(Contact contact) {
        contact.setId(null);
        contactRepository.save(contact);
    }

    public List<Contact> getAllContact() {
        return (List<Contact>) contactRepository.findAll();
    }

    public Contact getContactById(Integer contactId) {
        return contactRepository.findById(contactId).orElse(null);
    }

    public List<Contact> getContactByName(String firstname) {
        return (List<Contact>) contactRepository.findByFirstname(firstname);
    }

    public void updateContact(Contact contact, Integer contactId) {
        contact.setId(contactId);
        contactRepository.save(contact);
    }

    public void deleteContact(Integer contactId) {
        contactRepository.deleteById(contactId);
    }
}
