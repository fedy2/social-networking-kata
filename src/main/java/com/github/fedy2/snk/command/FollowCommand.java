/**
 * 
 */
package com.github.fedy2.snk.command;

import com.github.fedy2.snk.console.UserConsole;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class FollowCommand implements Command {
	
	private User user;
	private User friend;
	
	public User getUser() {
		return user;
	}

	public User getFriend() {
		return friend;
	}

	public FollowCommand(User user, User friend) {
		this.user = user;
		this.friend = friend;
	}

	@Override
	public void execute(UserConsole console) {
		user.addFriend(friend);
	}

}
