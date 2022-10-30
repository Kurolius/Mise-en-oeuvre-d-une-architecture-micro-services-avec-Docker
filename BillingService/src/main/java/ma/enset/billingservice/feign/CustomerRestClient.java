package ma.enset.billingservice.feign;

import ma.enset.billingservice.models.Customer;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collection;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {
    @GetMapping(path = "/api/customers/{id}")
    Customer getCustomerById(@PathVariable(name = "id") String id);

    @GetMapping(path = "api/customers")
    Collection<Customer> getAllCustomers();
}
