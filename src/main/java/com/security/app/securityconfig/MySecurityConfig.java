package com.security.app.securityconfig;

import org.springframework.security.core.userdetails.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.security.app.securityfilter.MySecurityFilter;

@Configuration
public class MySecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private MyAuthencationProvier authProvider;

	/**
	 *
	 */
//	@Override
//	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		InMemoryUserDetailsManager userDetailsService = new InMemoryUserDetailsManager();
//
//		// BCryptPasswordEncoder passwordEncoder=new BCryptPasswordEncoder();
//		UserDetails users = User.withUsername("dashrath").password(passwordEncoder.encode("rajput")).authorities("read")
//				.build();
//		userDetailsService.createUser(users);
//
//		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder);
//
//	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		 auth.authenticationProvider(authProvider);

	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic();
		//http.formLogin();
		//http.authorizeRequests().anyRequest().authenticated();
		
		http.authorizeRequests().antMatchers("/hello").authenticated();
		http.addFilterBefore(new MySecurityFilter(),BasicAuthenticationFilter.class);
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
