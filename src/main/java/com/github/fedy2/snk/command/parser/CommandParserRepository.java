/**
 * 
 */
package com.github.fedy2.snk.command.parser;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Service
public class CommandParserRepository {

	@Inject
	private List<CommandParser> parsers;

	public Optional<CommandParser> findParser(String line) {
		return parsers.stream().filter(p->p.canHandle(line)).findFirst();
	}
}
