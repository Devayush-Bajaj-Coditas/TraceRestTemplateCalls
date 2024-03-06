package com.devayush.PracticeDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import utils.LoggingInterceptor;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class PracticeDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(PracticeDemoApplication.class, args);
	}


	@Bean
	public RestTemplate restTemplate() {
		ClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();
		RestTemplate restTemplate = new RestTemplate(requestFactory);
		restTemplate.setInterceptors(Arrays.asList(new LoggingInterceptor()));
		return restTemplate;
	}

}
