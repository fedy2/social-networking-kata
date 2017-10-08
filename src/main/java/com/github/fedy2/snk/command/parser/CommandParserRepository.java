/**
 * 
 */
package com.github.fedy2.snk.command.parser;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Singleton
public class CommandParserRepository {

	private List<CommandParser> parsers;

	@Inject
	public CommandParserRepository(
			FollowCommandParser followParser, 
			PostCommandParser postParser, 
			ReadCommandParser readParser, 
			WallCommandParser wallParser) {
		
		this.parsers = Arrays.asList(
				followParser,
				postParser,
				readParser,
				wallParser
				);
	}

	public Optional<CommandParser> findParser(String line) {
		return parsers.stream().filter(p->p.canHandle(line)).findFirst();
	}
}
