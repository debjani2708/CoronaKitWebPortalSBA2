package com.wellsfaro.fsd.sba2.coronakit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication
//@ServletComponentScan("com.wellsfargo.fsd.ck.filter")
public class CoronaKitSbaSpringBootWebDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(CoronaKitSbaSpringBootWebDataApplication.class, args);
	}

}
