package com.carrent.rentprocesstask;

import com.carrent.rentprocesstask.services.RentProcessTaskRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableTask
public class RentProcessTaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(RentProcessTaskApplication.class, args);
    }

    @Bean
    RentProcessTaskRunner getRentProcessTaskRunner() {
        return new RentProcessTaskRunner();
    }

}
