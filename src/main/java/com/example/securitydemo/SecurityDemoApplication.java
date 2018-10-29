package com.example.securitydemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SecurityDemoApplication {

    /**
     *  JSP
     *  JSF -> filters -> filters -> html
     *  Thymeleaf
     *
     *
     *  2 classes to set up to deal with SS
     *  1. Configuration
     *  - URL - secured (everything else)
     *  - URL - non-secured (login, registration)
     *
     *  2. Filter
     *  - checks authentication
     */

    public static void main(String[] args) {
        SpringApplication.run(SecurityDemoApplication.class, args);
    }
}
