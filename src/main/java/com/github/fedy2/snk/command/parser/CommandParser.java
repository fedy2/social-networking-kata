/**
 * 
 */
package com.github.fedy2.snk.command.parser;

import com.github.fedy2.snk.command.Command;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public interface CommandParser {
	
	public boolean canHandle(String line);
	
	public Command parse(String line);

}
