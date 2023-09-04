package com.mlt.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ApiOperationsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiOperationsApplication.class, args);
    }

}
