package com.f1dpr;

import com.f1dpr.model.Driver;
import com.f1dpr.service.DriverSyncService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import static java.sql.DriverManager.println;

@SpringBootApplication
public class F1DriverPerformanceReviewApplication {

	public static void main(String[] args) {
		SpringApplication.run(F1DriverPerformanceReviewApplication.class, args);
	}
	@Bean
    CommandLineRunner initApi(DriverSyncService syncService) {
		return args -> {
			var pilotos = syncService.importarPilotos(2025);
			System.out.println("Pillotos da temporaada 2025");
			pilotos.forEach(piloto -> System.out.println(piloto.getName()));
		};
	}

}
