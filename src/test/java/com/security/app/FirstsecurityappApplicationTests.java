package com.security.app;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.DelegatingPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder;
import org.springframework.security.crypto.scrypt.SCryptPasswordEncoder;

@SpringBootTest
class FirstsecurityappApplicationTests {

	@Test
	void passwordEncoder_BCryptPasswordEncoder() {
		
		System.out.println(new BCryptPasswordEncoder().encode("rajput"));
	}
	
	@Test
	void passwordEncoder_Pbkdf2PasswordEncoder() {
		
		System.out.println(new Pbkdf2PasswordEncoder().encode("rajput"));
	}
	
	@Test
	void passwordEncoder_SCryptPasswordEncoder() {
		
		System.out.println(new SCryptPasswordEncoder().encode("rajput"));
	}
	
	@Test
	void passwordEncoder_DelegatingPasswordEncoder() {
		System.out.println("passwordEncoder_DelegatingPasswordEncoder start");
		Map<String, PasswordEncoder> passwordEncoder=new HashMap();
		
		passwordEncoder.put("Bcript", new BCryptPasswordEncoder());
		passwordEncoder.put("Script", new SCryptPasswordEncoder());
		System.out.println(new DelegatingPasswordEncoder("Script",passwordEncoder).encode("rajput"));
		System.out.println("passwordEncoder_DelegatingPasswordEncoder end");
	}

}
