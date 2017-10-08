/**
 * 
 */
package com.github.fedy2.snk.user;

import java.time.ZonedDateTime;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class Message {
	
	private final User author;
	private final ZonedDateTime sentTime;
	private final String text;
	
	public User getAuthor() {
		return author;
	}

	public ZonedDateTime getSentTime() {
		return sentTime;
	}

	public String getText() {
		return text;
	}

	public Message(User author, ZonedDateTime sentTime, String text) {
		this.author = author;
		this.sentTime = sentTime;
		this.text = text;
	}

}
