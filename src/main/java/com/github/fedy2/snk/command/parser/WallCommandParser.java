/**
 * 
 */
package com.github.fedy2.snk.command.parser;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.inject.Inject;

import org.springframework.stereotype.Component;

import com.github.fedy2.snk.command.Command;
import com.github.fedy2.snk.command.WallCommand;
import com.github.fedy2.snk.user.User;
import com.github.fedy2.snk.user.UserRepository;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Component
public class WallCommandParser implements CommandParser {
	
	private static final String WALL_PATTERN = "^(?<name>[^\\s]*) wall$";

	@Inject
	private UserRepository users;

	@Override
	public boolean canHandle(String line) {
		return line.matches(WALL_PATTERN);
	}

	@Override
	public Command parse(String line) {
		Matcher matcher = Pattern.compile(WALL_PATTERN).matcher(line);

		if (!matcher.matches()) {
			throw new IllegalArgumentException("Unparsable line " + line);
		}
		
		String name = matcher.group("name");
		
		User user = users.getOrCreate(name);
		
		WallCommand command = new WallCommand(user);
		return command;
	}
}
