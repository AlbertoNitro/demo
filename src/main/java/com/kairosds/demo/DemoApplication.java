package com.kairosds.demo;

import com.kairosds.demo.domain.services.SeederDBService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext app = SpringApplication.run(DemoApplication.class, args);
        SeederDBService seederDBService = (SeederDBService) app.getBean("seederDBService");
        seederDBService.setUp();
    }

}
