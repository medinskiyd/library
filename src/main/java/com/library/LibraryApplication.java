package com.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LibraryApplication { //extends SpringBootServletInitializer

	public static void main(String[] args) {
		SpringApplication.run(LibraryApplication.class, args);
	}

//	@Override
//	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
//		return application.sources(LibraryApplication.class);
//	}
}
