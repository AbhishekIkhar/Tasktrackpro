package com.syngenta.tasktrackpro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.liquibase.LiquibaseAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication()
@ComponentScan
@EnableJpaRepositories
public class TasktrackproApplication {
    
	
	public static void main(String[] args) {
		SpringApplication.run(TasktrackproApplication.class, args);
	}
    
	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}
}
