package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true,prePostEnabled = true)
public class EmpAppSecurityConfig extends WebSecurityConfigurerAdapter{

	@Bean
	public DriverManagerDataSource dataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("org.mariadb.jdbc.Driver");
		ds.setUrl("jdbc:mariadb://localhost:3306/springdb");
		ds.setUsername("root");
		ds.setPassword("root");
		return ds;
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/").permitAll()
		.antMatchers("/admin").hasRole("ADMIN")
		.antMatchers("/regform","/register")
		.hasAnyRole("USER","CLIENT")
		.and()
		.formLogin()
		.and().logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.and()
		.csrf()
		.disable();
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.inMemoryAuthentication().withUser("shantanu").password(encoder().encode("welcome1")).roles("USER");
		builder.inMemoryAuthentication().withUser("john").password(encoder().encode("welcome1")).roles("ADMIN");
		builder.inMemoryAuthentication().withUser("ankit").password(encoder().encode("welcome1")).roles("CLIENT");
	}
	
	/*@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
		builder.jdbcAuthentication().dataSource(dataSource())
		.usersByUsernameQuery("select username,password,enabled from users where username=?")
		.authoritiesByUsernameQuery("select username,authority from authorities where username=?");
	}*/
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
}
