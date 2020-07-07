package com.carrent.profile_server.service;

import com.carrent.model.Customer;
import com.carrent.profile_server.reposiotory.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Lakitha Prabudh on 7/4/20
 */
@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;

    public Customer save(Customer customer){
        return customerRepository.save(customer);
    }

    public Customer getById(int customerId){
        return customerRepository.findById(customerId).get();
    }

    public List<Customer> getAll(){
        return customerRepository.findAll();
    }
}
