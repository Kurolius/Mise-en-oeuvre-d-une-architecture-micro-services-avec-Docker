package ma.enset.billingservice.repositories;

import ma.enset.billingservice.entities.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

//@RepositoryRestResource
public interface InvoiceRespository extends JpaRepository<Invoice,String> {
    List<Invoice> findByCustomerId(String customerId);
}
