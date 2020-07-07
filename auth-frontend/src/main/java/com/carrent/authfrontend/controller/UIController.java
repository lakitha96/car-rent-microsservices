package com.carrent.authfrontend.controller;

import com.carrent.authfrontend.conf.AccessToken;
import com.carrent.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;

/**
 * @author Lakitha Prabudh on 7/7/20
 */
@Controller
@EnableOAuth2Sso
public class UIController extends WebSecurityConfigurerAdapter {

    private String profileServer = "http://localhost:9191";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/")
                .permitAll()
                .anyRequest()
                .authenticated();
    }

    @RequestMapping("/")
    public String loadHome() {
        return "home";
    }

    @RequestMapping("/secure")
    public String loadSecure() {
        return "secure";
    }

    @RequestMapping("/customers")
    public String loadSecurePage(Model model) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("Authorization", AccessToken.getAccessToken());
        HttpEntity<Customer> httpEntity = new HttpEntity<>(httpHeaders);
        String url = profileServer + "/customers";
        try {
            ResponseEntity<Customer[]> responseEntity = restTemplate.exchange(url, HttpMethod.GET, httpEntity, Customer[].class);
            model.addAttribute("customers", responseEntity.getBody());
        } catch (HttpStatusCodeException e) {
            ResponseEntity responseEntity = ResponseEntity.status(e.getRawStatusCode()).headers(e.getResponseHeaders()).body(e.getResponseBodyAsString());
            model.addAttribute("error", responseEntity);
        }
        return "secure";
    }
}
