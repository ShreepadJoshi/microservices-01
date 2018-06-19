package io.assignment.registration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;

import brave.sampler.Sampler;

@SpringBootApplication
@EnableEurekaServer
public class EurekaRegistrationServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(EurekaRegistrationServerApplication.class, args);
	}
	
	@Bean
	public Sampler sampler(){
		return Sampler.ALWAYS_SAMPLE;
	}
}
