package com.example.flightplan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class FlightplanApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlightplanApplication.class, args);
	}
}
