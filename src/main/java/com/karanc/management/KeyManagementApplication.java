package com.karanc.management;

import jakarta.persistence.Entity;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan(basePackages = {"com.karanc.management.*"})
@EnableScheduling
@Configuration
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.karanc.management.*"})
@EnableJpaRepositories(basePackages = {"com.karanc.management.*"}, entityManagerFactoryRef = "entityManagerFactory")
public class KeyManagementApplication {

	public static void main(String[] args) throws UnknownHostException, Exception {
		System.out.println("Hey, I am working fine.");
		System.setProperty("hostName", InetAddress.getLocalHost().getHostName());
		System.setProperty("applicationName", "KeyManagementApplication");

		SpringApplication.run(KeyManagementApplication.class, args);
	}

}
