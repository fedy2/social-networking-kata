/**
 * 
 */
package com.github.fedy2.snk.command;

import java.util.List;

import com.github.fedy2.snk.console.UserConsole;
import com.github.fedy2.snk.user.Message;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */

public class WallCommand implements Command {
	
	private User user;

	public User getUser() {
		return user;
	}

	public WallCommand(User user) {
		this.user = user;
	}

	@Override
	public void execute(UserConsole console) {
		List<Message> wall = user.getWall();
		
		for (Message message : wall) {
			console.write(message);
		}
	}
}
