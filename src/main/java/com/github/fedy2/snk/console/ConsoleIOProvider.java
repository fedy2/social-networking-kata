/**
 * 
 */
package com.github.fedy2.snk.console;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Module
public class ConsoleIOProvider {

	@Provides @Singleton
	public ConsoleIO provideConsoleIO() {
		return new CLConsoleIO();
	}
}
