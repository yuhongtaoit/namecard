package com.zhongwei.namecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class NamecardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NamecardApplication.class, args);
	}

}

