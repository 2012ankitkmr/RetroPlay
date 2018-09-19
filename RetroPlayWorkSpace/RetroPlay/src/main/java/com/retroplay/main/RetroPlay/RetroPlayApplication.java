package com.retroplay.main.RetroPlay;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"retroplay.controllers","retroplay.services","retroplay.dao"})
@EntityScan(basePackages = "retroplay.models")
@SpringBootApplication
public class RetroPlayApplication {

	public static void main(String[] args) {
		SpringApplication.run(RetroPlayApplication.class, args);
	}
}
