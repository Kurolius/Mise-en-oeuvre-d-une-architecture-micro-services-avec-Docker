package ma.enset.customerservice.services;


import ma.enset.customerservice.dto.CustomerRequestDTO;
import ma.enset.customerservice.dto.CustomerResponseDTO;

import java.util.List;

public interface CustomerService {
    CustomerResponseDTO getCustomer(String id);
    List<CustomerResponseDTO> getCustomers();
    CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO);
    CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO);
    void deleteCustomer(String id);
}
