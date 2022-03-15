package com.security.app.securityconfig;

import java.util.Arrays;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
public class MyAuthencationProvier implements AuthenticationProvider {

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		// TODO Auto-generated method stub
		
		String user= authentication.getName();
		String password = authentication.getCredentials().toString();
		if("dashrath1".equals(user)&& "rajput1".equals(password)) {
			return new UsernamePasswordAuthenticationToken(user,password,Arrays.asList());
		}else throw new BadCredentialsException("Invalid user or password");
		
		 
	}

	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
