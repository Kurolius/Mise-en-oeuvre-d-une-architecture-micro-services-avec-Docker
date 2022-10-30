package ma.enset.customerservice;

import ma.enset.customerservice.dto.CustomerRequestDTO;
import ma.enset.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner start(CustomerService customerService){
		return args -> {
			customerService.save(new CustomerRequestDTO("001","Adria","med@adria.com"));
			customerService.save(new CustomerRequestDTO("002","LinkedIn","linked@adria.com"));
		};
	}
}
