/**
 * 
 */
package com.github.fedy2.snk;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
public class SocialNetworkingKata {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SocialNetwork socialNetwork = DaggerSocialNetworkFactory.create().createSocialNetwork();
		socialNetwork.processUserCommands();
	}

}
