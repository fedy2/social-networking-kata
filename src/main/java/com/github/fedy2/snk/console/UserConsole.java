/**
 * 
 */
package com.github.fedy2.snk.console;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.github.fedy2.snk.user.Message;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Component
public class UserConsole {
	
	@Inject
	private MessageFormatter formatter;
	
	@Inject
	private ConsoleIO console;

	public String readCommand() {
		return console.readLine();
	}
	
	public void write(Message message) {
		String line = formatter.format(message);
		write(line);
	}
	
	public void write(String text) {
		console.writeLine(text);
	}
}
