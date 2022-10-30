package ma.enset.billingservice.services;

import ma.enset.billingservice.dtos.InvoiceResponseDTO;
import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.exception.CustomerNotFoundException;

import java.util.List;

public interface InvoiceService {
    InvoiceResponseDTO save(InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException;
    InvoiceResponseDTO getInvoice(String invoiceId);
    List<InvoiceResponseDTO> getInvoices();
    List<InvoiceResponseDTO> invoicesByCustomerId(String customerId);

}
