package com.taxconsultant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableJpaRepositories(basePackages="com.taxconsultant.repository")
@ComponentScan(basePackages = "com.taxconsultant")
@EnableSwagger2
@EntityScan("com.taxconsultant.entites")
public class TaxConsultentApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaxConsultentApplication.class, args);
	}
}
