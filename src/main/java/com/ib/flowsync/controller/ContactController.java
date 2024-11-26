package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Contact;
import com.ib.flowsync.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@CrossOrigin(origins = "http://localhost:4200/", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class ContactController {

    @Autowired
    ContactService contactService;

    @PostMapping("")
    public ResponseEntity<String> createContact(
            @RequestBody Contact contact
    ) {
        contactService.createContact(contact);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Contact creation was successful");
    }

    @GetMapping("")
    public List<Contact> getAllContact() {
        return contactService.getAllContact();
    }

    @GetMapping("/{contactId}")
    public @ResponseBody Contact getContactById(
            @PathVariable(value = "contactId") Integer contactId
    ) throws ResponseStatusException {
        Contact contact = contactService.getContactById(contactId);

        if (contact == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "contact not found");

        return contact;
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<String> updateContact(
            @PathVariable(value = "contactId") Integer contactId,
            @RequestBody Contact contact
    ) {
        contactService.updateContact(contact, contactId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Contact update was successful");
    }

    @DeleteMapping("/{contactId}")
    public void deleteContact(
            @PathVariable(value = "contactId") Integer contactId
    ) {
        contactService.deleteContact(contactId);
    }
}
