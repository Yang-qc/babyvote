package com.babyvote.work;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
//@EnableDiscoveryClient
//@ComponentScan(basePackages={"com.ketai.api.**","com.ketai.activity.**",
//        "com.ketai.model.domain"})//扫描接口
public class BabyVoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(BabyVoteApplication.class, args);
    }
}
