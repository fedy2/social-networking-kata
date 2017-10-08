/**
 * 
 */
package com.github.fedy2.snk.console;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Configuration
public class ConsoleIOProvider {

	@Bean
	public ConsoleIO provideConsoleIO() {
		return new CLConsoleIO();
	}
}
