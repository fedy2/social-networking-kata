/**
 * 
 */
package com.github.fedy2.snk.command;

import com.github.fedy2.snk.console.Console;
import com.github.fedy2.snk.user.Message;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class ReadCommand implements Command {
	
	private User user;
	
	public User getUser() {
		return user;
	}

	public ReadCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute(Console console) {
		for (Message message : user.getMessages()) {
			console.write(message);
		}
	}

}
