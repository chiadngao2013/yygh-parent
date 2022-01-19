package com.atguigu.yygh.hosp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
@EnableFeignClients(basePackages = "com.atguigu")
@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = "com.atguigu")//设置扫描路径，将在其他的项目config也能扫描进来
public class ServiceHospApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHospApplication.class, args);
    }
}
