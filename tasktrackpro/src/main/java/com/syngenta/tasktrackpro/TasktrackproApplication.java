package com.syngenta.tasktrackpro;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import net.bytebuddy.asm.Advice.Return;

@SpringBootApplication
public class TasktrackproApplication {

	@Bean
	public ModelMapper modelMapper() {
		return new ModelMapper();
	}

	public static void main(String[] args) {
		SpringApplication.run(TasktrackproApplication.class, args);
	}

}
