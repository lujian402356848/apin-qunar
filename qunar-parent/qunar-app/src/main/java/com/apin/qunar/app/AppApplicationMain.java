package com.apin.qunar.app;

import com.apin.qunar.common.utils.SpringContextUtil;
import com.apin.qunar.order.common.redis.NtsFlightRedis;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.ArrayList;
import java.util.List;

/**
 * @outhor lujian
 * @create 2018-06-20 16:29
 */
@EnableScheduling
@EnableTransactionManagement
@SpringBootApplication
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class})
@ComponentScan(basePackages = {"com.apin.qunar"})
public class AppApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(AppApplicationMain.class, args);
        NtsFlightRedis redis = SpringContextUtil.getBean(NtsFlightRedis.class);
        User user = new User();
        user.setName("lujian");
        List<User.Student> studentList = new ArrayList<>();
        User.Student student = new User.Student();
        student.setAge(12);
        studentList.add(student);
        student = new User.Student();
        student.setAge(16);
        user.setName("ffff");
        studentList.add(student);
        user.setStudents(studentList);

        redis.setFlightInfo("a", user);

        User user1 = (User) redis.getFlightInfo("a", User.class);
    }
}