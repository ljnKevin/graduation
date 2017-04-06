package com.wechat;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("com.wechat.domain")
@SpringBootApplication
@EntityScan("com.wechat.domain.entity")
@ComponentScan("com.wechat")
@PropertySource(value = {"classpath:application.properties"})
public class StdApplication  {
    public static void main(String[] args) {
        SpringApplication.run(StdApplication.class, args);
    }
}
