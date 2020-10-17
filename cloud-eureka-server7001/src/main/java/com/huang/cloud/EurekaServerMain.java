package com.huang.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author :huangao
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerMain {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerMain.class,args);
    }
}
