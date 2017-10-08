package com.github.fedy2.snk.command;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyZeroInteractions;

import java.time.ZonedDateTime;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.fedy2.snk.console.UserConsole;
import com.github.fedy2.snk.user.Message;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReadCommandTest {
	
	private ReadCommand command;
	private User user;
	private UserConsole console;

	@Before
	public void setUp() throws Exception {
		user = new User("MyUser");
		
		command = new ReadCommand(user);
		
		console = mock(UserConsole.class);
	}

	@Test
	public void testExecute() {
		Message message = new Message(user, ZonedDateTime.now(), "Hello");
		user.postMessage(message);
		
		command.execute(console);
		
		verify(console).write(message);
	}
	
	@Test
	public void testExecuteWithNoMessages() {
		command.execute(console);
		
		verifyZeroInteractions(console);
	}

}
