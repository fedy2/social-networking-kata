package com.github.fedy2.snk.console;

import static org.junit.Assert.assertTrue;

import java.time.ZonedDateTime;

import org.junit.Test;

import com.github.fedy2.snk.console.MessageFormatter;
import com.github.fedy2.snk.user.Message;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class MessageFormatterTest {
	
	private static final User AUTHOR = new User("Alice");
	private static final String TEXT = "I love the weather today";

	private MessageFormatter formatter = new MessageFormatter();

	@Test
	public void testFormatTimeLessThanMinute() {
		ZonedDateTime sentTime = ZonedDateTime.now();
		Message message = new Message(AUTHOR, sentTime, TEXT);
		
		String line = formatter.format(message);
		
		assertTrue(line.matches("Alice - I love the weather today \\(\\d seconds ago\\)"));
	}

	@Test
	public void testFormatTimeMoreThanMinute() {
		ZonedDateTime sentTime = ZonedDateTime.now().minusMinutes(5);
		Message message = new Message(AUTHOR, sentTime, TEXT);
		
		String line = formatter.format(message);
		
		assertTrue(line.matches("Alice - I love the weather today \\(\\d minutes ago\\)"));
	}
}
