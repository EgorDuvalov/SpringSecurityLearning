package com.innowise.springsecurity.config;

import com.innowise.springsecurity.security.jwt.JwtConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	private final JwtConfigurer jwtConfigurer;

	public SpringSecurityConfig(JwtConfigurer jwtConfigurer) {
		this.jwtConfigurer = jwtConfigurer;
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
			.csrf().disable()
			.authorizeRequests()
			.antMatchers("/","/api/v1/passport/login").permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.apply(jwtConfigurer);
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Bean
	protected PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder(12);
	}

}
