package ma.enset.billingservice;

import ma.enset.billingservice.dtos.InvoiceRequestDTO;
import ma.enset.billingservice.exception.CustomerNotFoundException;
import ma.enset.billingservice.feign.CustomerRestClient;
import ma.enset.billingservice.models.Customer;
import ma.enset.billingservice.repositories.InvoiceRespository;
import ma.enset.billingservice.services.InvoiceService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import java.math.BigDecimal;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(InvoiceService invoiceService) {
        return args -> {
            try {
                invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(527550),"001"));
                invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(200000),"001"));
                invoiceService.save(new InvoiceRequestDTO(BigDecimal.valueOf(550),"002"));
            } catch (CustomerNotFoundException e) {
                throw new RuntimeException(e);
            }

        };
    }
}
