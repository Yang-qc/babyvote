package com.babyvote.work;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableScheduling
@EnableDiscoveryClient
@EnableSwagger2
//@ComponentScan(basePackages={"com.babyvote.work.**"})//扫描接口
public class BabyVoteApplication {
    public static void main(String[] args) {
        SpringApplication.run(BabyVoteApplication.class, args);
    }
}