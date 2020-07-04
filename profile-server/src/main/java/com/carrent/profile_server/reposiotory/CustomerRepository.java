package com.carrent.profile_server.reposiotory;

import com.carrent.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Lakitha Prabudh on 7/4/20
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Integer> {
}
