package com.carrent.profile_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "com.carrent.model")
public class ProfileServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProfileServerApplication.class, args);
    }

}
