/**
 * 
 */
package com.github.fedy2.snk;

import javax.inject.Inject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@SpringBootApplication
public class SocialNetworkingKata implements CommandLineRunner {
	
	@Inject
	private SocialNetwork network;

	@Override
	public void run(String... args) {
		network.start();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(SocialNetworkingKata.class, args);
	}
}
