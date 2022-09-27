package kz.assel.springcourse.SpringBootApp.services;

import kz.assel.springcourse.SpringBootApp.models.Customer;
import kz.assel.springcourse.SpringBootApp.repositories.CustomerRepository;
import kz.assel.springcourse.SpringBootApp.security.CustomerDetails;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerDetailsService  implements UserDetailsService {

    private final CustomerRepository customerRepository;

    public CustomerDetailsService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<Customer> customer = customerRepository.findByUsername(s);

        if(customer.isEmpty()){
            throw new UsernameNotFoundException("Customer not found!");
        }

        return new CustomerDetails(customer.get());
    }
}
