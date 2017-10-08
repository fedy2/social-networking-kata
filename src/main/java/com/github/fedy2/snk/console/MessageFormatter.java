/**
 * 
 */
package com.github.fedy2.snk.console;

import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;

import javax.inject.Inject;
import javax.inject.Singleton;

import com.github.fedy2.snk.user.Message;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Singleton
public class MessageFormatter {
	
	@Inject
	public MessageFormatter() {
	}
	
	public String format(Message message) {
		StringBuilder line = new StringBuilder();

		User author = message.getAuthor();
		line.append(author.getName());

		line.append(" - ");
		line.append(message.getText());

		ZonedDateTime messageTime = message.getSentTime();
		long seconds = messageTime.until(ZonedDateTime.now(), ChronoUnit.SECONDS);

		if (seconds < 60) {
			line.append(" (").append(seconds).append(" seconds ago)");
		} else {
			long minutes = messageTime.until(ZonedDateTime.now(), ChronoUnit.MINUTES);
			line.append(" (").append(minutes).append(" minutes ago)");
		}
		
		return line.toString();
	}

}
