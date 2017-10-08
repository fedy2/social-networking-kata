/**
 * 
 */
package com.github.fedy2.snk;

import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.github.fedy2.snk.command.Command;
import com.github.fedy2.snk.command.parser.CommandParser;
import com.github.fedy2.snk.command.parser.CommandParserRepository;
import com.github.fedy2.snk.console.UserConsole;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Service
public class SocialNetwork {

	@Inject
	private UserConsole console;

	@Inject
	private CommandParserRepository parserRepository;

	public void start() {
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
