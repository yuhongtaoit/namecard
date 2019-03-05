package com.zhongwei.namecard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication()
public class NamecardApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(NamecardApplication.class, args);
	}

}

