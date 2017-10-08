package com.github.fedy2.snk.command;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.fedy2.snk.console.Console;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class FollowCommandTest {

	private FollowCommand command;
	private User user;
	private User friend;
	private Console console;
	
	@Before
	public void setup() {
		user = new User("MyUser");
		friend = new User("Friend");
		
		command = new FollowCommand(user, friend);
		
		console = mock(Console.class);
	}
	
	@Test
	public void testExecute() {
		command.execute(console);
		
		assertTrue(user.getFriends().contains(friend));
	}

}
