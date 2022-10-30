package ma.enset.customerservice.services;


import ma.enset.customerservice.dto.CustomerRequestDTO;
import ma.enset.customerservice.dto.CustomerResponseDTO;
import ma.enset.customerservice.entities.Customer;
import ma.enset.customerservice.mappers.CustomerMapper;
import ma.enset.customerservice.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerServiceImpl implements CustomerService {
    private CustomerRepository customerRepository;
    private CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public CustomerResponseDTO getCustomer(String id) {
        Customer customer=customerRepository.findById(id).get();
        return customerMapper.customerToCustomerDTO(customer);
    }

    @Override
    public List<CustomerResponseDTO> getCustomers() {
        List<Customer> customers=customerRepository.findAll();
        return customers.stream().map((customer)->customerMapper.customerToCustomerDTO(customer)).collect(Collectors.toList());
    }

    @Override
    public CustomerResponseDTO save(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @Override
    public CustomerResponseDTO update(CustomerRequestDTO customerRequestDTO) {
        Customer customer=customerMapper.customerRequestDtoToCustomer(customerRequestDTO);
        Customer savedCustomer=customerRepository.save(customer);
        return customerMapper.customerToCustomerDTO(savedCustomer);
    }

    @Override
    public void deleteCustomer(String id) {
        customerRepository.deleteById(id);
    }
}
