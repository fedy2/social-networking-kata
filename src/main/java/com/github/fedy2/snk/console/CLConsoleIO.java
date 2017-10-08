/**
 * 
 */
package com.github.fedy2.snk.console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class CLConsoleIO implements ConsoleIO {
	
	private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

	@Override
	public String readLine() {
		try {
			return reader.readLine();
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void writeLine(String line) {
		System.out.println(line);
	}

}
