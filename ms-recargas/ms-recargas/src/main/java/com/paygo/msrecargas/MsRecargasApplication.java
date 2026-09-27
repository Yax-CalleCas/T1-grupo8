package com.paygo.msrecargas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MsRecargasApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsRecargasApplication.class, args);
    }
}