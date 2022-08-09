package com.meusprojetos.modeloHateoas;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@EnableSpringDataWebSupport
@SpringBootApplication
public class ModeloHateoasApplication {

	public static void main(String[] args) {
		SpringApplication.run(ModeloHateoasApplication.class, args);
	}

}
