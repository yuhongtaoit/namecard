package com.zhongwei.namecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class,HibernateJpaAutoConfiguration.class,SecurityAutoConfiguration.class})
public class NamecardApplication {
	
	@RequestMapping("/")
    public String index(){
		System.out.println(1111);
        return "Hello Spring Boot";
        
    }

	public static void main(String[] args) {
		SpringApplication.run(NamecardApplication.class, args);
	}

}

