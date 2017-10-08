/**
 * 
 */
package com.github.fedy2.snk;

import java.util.Optional;

import javax.inject.Inject;

import com.github.fedy2.snk.command.Command;
import com.github.fedy2.snk.command.parser.CommandParser;
import com.github.fedy2.snk.command.parser.CommandParserRepository;
import com.github.fedy2.snk.console.UserConsole;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class SocialNetwork {

	private UserConsole console;

	private CommandParserRepository parserRepository;

	@Inject
	public SocialNetwork(UserConsole console, CommandParserRepository parserRepository) {
		this.console = console;
		this.parserRepository = parserRepository;
	}

	public void processUserCommands() {
		String line;
		while ((line = console.readCommand()) != null) {
			parseAndExecuteCommand(line);
		}

		console.write("bye");
	}

	private void parseAndExecuteCommand(String line) {
		Optional<CommandParser> parser = parserRepository.findParser(line);
		if (parser.isPresent()) {
			Command command = parser.get().parse(line);
			command.execute(console);
		} else {
			console.write("Unknown command: " + line);
		}

	}
}
