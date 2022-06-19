package com.fedormulashkin.changeusd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ExchangeUsdApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExchangeUsdApplication.class, args);
    }
}
