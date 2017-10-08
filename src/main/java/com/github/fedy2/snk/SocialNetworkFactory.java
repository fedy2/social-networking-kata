/**
 * 
 */
package com.github.fedy2.snk;

import javax.inject.Singleton;

import com.github.fedy2.snk.console.ConsoleIOProvider;

import dagger.Component;

/**
 * @author "Federico De Faveri defaveri@gmail.com"
 *
 */
@Singleton
@Component(modules=ConsoleIOProvider.class)
public interface SocialNetworkFactory {

	SocialNetwork createSocialNetwork();
}
