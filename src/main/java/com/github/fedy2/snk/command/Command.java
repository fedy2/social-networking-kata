/**
 * 
 */
package com.github.fedy2.snk.command;

import com.github.fedy2.snk.console.Console;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public interface Command {

	/**
	 * Executes the command using the passed {@link Console}.
	 * @param console
	 */
	void execute(Console console);
}
