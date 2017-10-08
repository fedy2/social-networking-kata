/**
 * 
 */
package com.github.fedy2.snk.console;

import javax.inject.Inject;

import com.github.fedy2.snk.user.Message;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class UserConsole {
	
	private MessageFormatter formatter;
	
	private ConsoleIO console;
	
	@Inject
	public UserConsole(MessageFormatter formatter, ConsoleIO console) {
		this.formatter = formatter;
		this.console = console;
	}

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
