package com.ib.flowsync.controller;

import com.ib.flowsync.entity.Invoice;
import com.ib.flowsync.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/invoices")
public class InvoiceController {
    
    @Autowired
    InvoiceService invoiceService;

    @PostMapping("")
    public ResponseEntity<String> createInvoice(
            @RequestBody Invoice invoice
    ) {
        invoiceService.createInvoice(invoice);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body("Invoice creation was successful");
    }

    @GetMapping("")
    public List<Invoice> getAllInvoice() {
        return invoiceService.getAllInvoice();
    }

    @GetMapping("/{invoiceId}")
    public @ResponseBody Invoice getInvoiceById(
            @PathVariable(value = "invoiceId") Integer invoiceId
    ) throws ResponseStatusException {
        Invoice invoice = invoiceService.getInvoiceById(invoiceId);

        if (invoice == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice not found");

        return invoice;
    }

    @PutMapping("/{invoiceId}")
    public ResponseEntity<String> updateInvoice(
            @PathVariable(value = "invoiceId") Integer invoiceId,
            @RequestBody Invoice invoice
    ) {
        invoiceService.updateInvoice(invoice, invoiceId);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Invoice update was successful");
    }

    @DeleteMapping("/{invoiceId}")
    public @ResponseBody void deleteInvoice(
            @PathVariable(value = "invoiceId") Integer invoiceId
    ) {
        invoiceService.deleteInvoice(invoiceId);
    }

}
