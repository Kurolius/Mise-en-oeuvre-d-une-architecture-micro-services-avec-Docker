package ma.enset.billingservice.web;

import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.dtos.InvoiceResponseDTO;
import ma.enset.billingservice.exception.CustomerNotFoundException;
import ma.enset.billingservice.repositories.InvoiceRespository;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
public class BillingRestController {
    @Autowired
    private InvoiceService invoiceService;


    @GetMapping(path = "/invoices")
    public List<InvoiceResponseDTO> getInvoices(){
        return invoiceService.getInvoices();
    }

    @GetMapping(path = "/invoices/{id}")
    public InvoiceResponseDTO getInvoice(@PathVariable(name = "id") String id){
        InvoiceResponseDTO invoiceResponseDTO = invoiceService.getInvoice(id);
        return invoiceResponseDTO;
    }

    @GetMapping(path = "/invoicesByCustomer/{customerId}")
    public List<InvoiceResponseDTO> getInvoicesByCustomerId(@PathVariable String customerId){
        List<InvoiceResponseDTO> invoiceResponseDTOS = invoiceService.invoicesByCustomerId(customerId);
        return invoiceResponseDTOS;
    }

    @PostMapping(path = "/invoices")
    public InvoiceResponseDTO save(@RequestBody InvoiceRequestDTO invoiceRequestDTO) throws CustomerNotFoundException {
        return invoiceService.save(invoiceRequestDTO);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> exceptionHandler(Exception e){
        return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
