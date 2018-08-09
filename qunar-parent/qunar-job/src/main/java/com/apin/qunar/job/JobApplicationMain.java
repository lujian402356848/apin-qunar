package com.apin.qunar.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @outhor lujian
 * @create 2018-06-20 16:29
 */
@EnableScheduling
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.apin.qunar"})
public class JobApplicationMain {
    public static void main(String[] args) throws Exception {
        SpringApplication.run(JobApplicationMain.class, args);
    }
}