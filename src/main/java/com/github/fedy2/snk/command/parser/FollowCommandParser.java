/**
 * 
 */
package com.github.fedy2.snk.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import com.github.fedy2.snk.command.Command;
import com.github.fedy2.snk.command.FollowCommand;
import com.github.fedy2.snk.user.User;
import com.github.fedy2.snk.user.UserRepository;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class FollowCommandParser implements CommandParser {

	private static final String FOLLOW_PATTERN = "^(?<name>[^\\s]*) follows (?<friend>[^\\s]*)$";

	private UserRepository users;

	@Inject
	public FollowCommandParser(UserRepository users) {
		this.users = users;
	}

	@Override
	public boolean canHandle(String line) {
		return line.matches(FOLLOW_PATTERN);
	}

	@Override
	public Command parse(String line) {
		Matcher matcher = Pattern.compile(FOLLOW_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unparsable line " + line);
		}

		String userName = matcher.group("name");
		String friendName = matcher.group("friend");

		User user = users.getOrCreate(userName);
		User friend = users.getOrCreate(friendName);

		FollowCommand command = new FollowCommand(user, friend);
		return command;
	}
}
