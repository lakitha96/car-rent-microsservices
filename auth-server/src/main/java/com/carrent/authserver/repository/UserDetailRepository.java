package com.carrent.authserver.repository;

import com.carrent.authserver.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
public interface UserDetailRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUsername(String name);
}
