package com.orchard;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class OrchardApplication  {

    public static void main(String[] args) {
        SpringApplication.run(OrchardApplication.class,args);
        log.info("Server started");
    }


}
