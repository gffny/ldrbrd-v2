package com.gffny.ldrbrd.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * 
 * @author John D. Gaffney | gffny.com
 *
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/**
	 * 
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http

		// Authorize access to URLs.
		.authorizeRequests()

				// Login form (/login, /login?logout and /login?error) should be
				// available to anyone.
				.antMatchers("/login*").permitAll()

				// Certain admin URLs require a user with the admin role.
				.antMatchers("/admin/**").hasRole("ADMIN")
				.antMatchers("/**/admin").hasRole("ADMIN")

				// All other URLs require an authenticated user.
				.anyRequest().authenticated()

				// Enable form-based log in with custom form (login.html and
				// LoginWebController.java).
				.and().formLogin().loginPage("/login")

				// Disable CSRF protection. I can't make it work with ThymeLeaf.
				.and().csrf().disable();

	}

	/**
	 * Set up a static list of users recognized by the application. This is a short
	 * term solution until we can integrate with Harvard's PIN/CAS.
	 * 
	 * The name of this method is unimportant; Spring finds it by signature.
	 * @param auth
	 * @throws Exception
	 */
	@Autowired
	protected void configureGlobal(AuthenticationManagerBuilder auth)
			throws Exception {

		//LeaderboardAuthentication.configureLoginsAndRoles(auth);

	}

}