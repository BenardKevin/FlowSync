package com.ib.flowsync.service;

import com.ib.flowsync.entity.Invoice;
import com.ib.flowsync.entity.Order;
import com.ib.flowsync.repository.InvoiceRepository;
import com.ib.flowsync.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    InvoiceRepository invoiceRepository;

    public void createInvoice(Invoice invoice) {
        invoice.setId(null);
        invoiceRepository.save(invoice);
    }

    public List<Invoice> getAllInvoice() {
        return (List<Invoice>) invoiceRepository.findAll();
    }

    public Invoice getInvoiceById(Integer invoiceId) {
        return invoiceRepository.findById(invoiceId).orElse(null);
    }

    public void updateInvoice(Invoice invoice, Integer invoiceId) {
        invoice.setId(invoiceId);
        invoiceRepository.save(invoice);
    }

    public void deleteInvoice(Integer invoiceId) {
        invoiceRepository.deleteById(invoiceId);
    }
}
