package com.website_of_holding.app_of_holding;

import com.website_of_holding.app_of_holding.model.PlayerCharacter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@SpringBootApplication
public class AppOfHoldingApplication {

	public static void main(String[] args) {

		SpringApplication.run(AppOfHoldingApplication.class, args);
	}
}
