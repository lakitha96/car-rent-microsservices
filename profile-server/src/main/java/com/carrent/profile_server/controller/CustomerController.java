package com.carrent.profile_server.controller;

import com.carrent.model.Customer;
import com.carrent.profile_server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Lakitha Prabudh on 7/4/20
 */
@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    @PreAuthorize("hasAnyAuthority('create_profile')")
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }

    @GetMapping("/{customerId}")
    @PreAuthorize("hasRole('ROLE_admin')")
    public Customer save(@PathVariable int customerId) {
        return customerService.getById(customerId);
    }

    @GetMapping
    @PreAuthorize("hasRole('ROLE_admin')")
    public List<Customer> getAll() {
        return customerService.getAll();
    }
}
