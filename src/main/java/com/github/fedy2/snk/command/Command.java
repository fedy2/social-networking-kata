/**
 * 
 */
package com.github.fedy2.snk.command;

import com.github.fedy2.snk.console.UserConsole;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public interface Command {

	/**
	 * Executes the command using the passed {@link UserConsole}.
	 * @param console
	 */
	void execute(UserConsole console);
}
