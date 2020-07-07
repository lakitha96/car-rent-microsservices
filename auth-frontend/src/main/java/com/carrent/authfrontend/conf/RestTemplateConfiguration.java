package com.carrent.authfrontend.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
@Configuration
public class RestTemplateConfiguration {

    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
