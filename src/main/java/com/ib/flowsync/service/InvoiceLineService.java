package com.ib.flowsync.service;

import com.ib.flowsync.entity.InvoiceLine;
import com.ib.flowsync.repository.InvoiceLineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceLineService {

    @Autowired
    InvoiceLineRepository invoiceLineRepository;

    public void createInvoiceLine(InvoiceLine invoiceLine) {
        invoiceLine.setId(null);
        invoiceLineRepository.save(invoiceLine);
    }

    public List<InvoiceLine> getAllInvoiceLine() {
        return (List<InvoiceLine>) invoiceLineRepository.findAll();
    }

    public InvoiceLine getInvoiceLineById(Integer id) {
        return invoiceLineRepository.findById(id).orElse(null);
    }

    public void updateInvoiceLine(InvoiceLine invoiceLine, Integer id) {
        invoiceLine.setId(id);
        invoiceLineRepository.save(invoiceLine);
    }

    public void deleteInvoiceLine(Integer id) {
        invoiceLineRepository.deleteById(id);
    }
}
