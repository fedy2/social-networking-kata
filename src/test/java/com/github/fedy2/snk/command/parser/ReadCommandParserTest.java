package com.github.fedy2.snk.command.parser;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import com.github.fedy2.snk.command.Command;
import com.github.fedy2.snk.command.ReadCommand;
import com.github.fedy2.snk.command.parser.ReadCommandParser;
import com.github.fedy2.snk.user.User;
import com.github.fedy2.snk.user.UserRepository;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class ReadCommandParserTest {

	@InjectMocks
	private ReadCommandParser parser;

	@Mock
	private UserRepository users;

	@Mock
	private User alice;

	@Before
	public void setup() {
		when(users.getOrCreate("Alice")).thenReturn(alice);
	}

	@Test
	public void testCanHandle() {
		boolean canHandle = parser.canHandle("Alice");
		assertTrue(canHandle);
	}

	@Test
	public void testCanHandleWithUnparsableLine() {
		boolean canHandle = parser.canHandle("NOT_PARSABLE COMMAND");
		assertFalse(canHandle);
	}

	@Test
	public void testParse() {
		Command command = parser.parse("Alice");

		assertTrue(command instanceof ReadCommand);

		ReadCommand readCommand = (ReadCommand)command;
		User user = readCommand.getUser();
		assertEquals(alice, user);
	}
}
