/**
 * 
 */
package com.github.fedy2.snk.command;

import java.time.ZonedDateTime;

import com.github.fedy2.snk.console.Console;
import com.github.fedy2.snk.user.Message;
import com.github.fedy2.snk.user.User;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class PostCommand implements Command {
	
	private User author;
	private String text;
	
	public User getAuthor() {
		return author;
	}

	public String getText() {
		return text;
	}

	public PostCommand(User author, String text) {
		this.author = author;
		this.text = text;
	}

	@Override
	public void execute(Console console) {
		Message message = new Message(author, ZonedDateTime.now(), text);
		author.postMessage(message);
	}
}
