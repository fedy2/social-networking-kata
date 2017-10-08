/**
 * 
 */
package com.github.fedy2.snk.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.github.fedy2.snk.command.Command;
import com.github.fedy2.snk.command.PostCommand;
import com.github.fedy2.snk.user.User;
import com.github.fedy2.snk.user.UserRepository;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class PostCommandParser implements CommandParser {
	
	private static final String POST_PATTERN = "^(?<name>[^\\s]*) -> (?<message>.*)$";
	
	private UserRepository users;

	@Inject
	public PostCommandParser(UserRepository users) {
		this.users = users;
	}

	@Override
	public boolean canHandle(String line) {
		return line.matches(POST_PATTERN);
	}

	@Override
	public Command parse(String line) {
		Matcher matcher = Pattern.compile(POST_PATTERN).matcher(line);
		
		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unparsable line " + line);
		}
		
		String name = matcher.group("name");
		String message = matcher.group("message");
		
		User user = users.getOrCreate(name);
		
		PostCommand command = new PostCommand(user, message);
		return command;
	}
}
