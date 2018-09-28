package com.registrysrv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.schema.server.EnableSchemaRegistryServer;

@SpringBootApplication
@EnableSchemaRegistryServer
public class SchemaRegistryServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SchemaRegistryServerApplication.class, args);
	}
}
