package com.carrent.profile_server.controller;

import com.carrent.model.Customer;
import com.carrent.profile_server.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Lakitha Prabudh on 7/4/20
 */
@RestController
@RequestMapping("/profiles")
public class ProfileController {

    @Autowired
    private CustomerService customerService;

    @PostMapping
    public Customer save(@RequestBody Customer customer) {
        return customerService.save(customer);
    }
}
