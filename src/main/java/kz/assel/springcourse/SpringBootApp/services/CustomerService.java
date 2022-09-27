package kz.assel.springcourse.SpringBootApp.services;

import kz.assel.springcourse.SpringBootApp.models.Customer;
import kz.assel.springcourse.SpringBootApp.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CustomerService {
    public final CustomerRepository customersRepository;

    @Autowired
    public CustomerService(CustomerRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public List<Customer> getAll(){
        return customersRepository.findAll();
    }

    public Customer getById(int id){
        Optional<Customer> customer =  customersRepository.findById(id);

        return customer.orElse(null);
    }

    @Transactional
    public void add(Customer customer){
        customersRepository.save(customer);
    }

    @Transactional
    public void delete(int id){
        customersRepository.deleteById(id);
    }
}
