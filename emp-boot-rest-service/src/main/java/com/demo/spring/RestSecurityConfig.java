/*
 * package com.demo.spring;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.context.annotation.Bean; import
 * org.springframework.context.annotation.Configuration; import
 * org.springframework.security.config.annotation.authentication.builders.
 * AuthenticationManagerBuilder; import
 * org.springframework.security.config.annotation.web.builders.HttpSecurity;
 * import org.springframework.security.config.annotation.web.configuration.
 * EnableWebSecurity; import
 * org.springframework.security.config.annotation.web.configuration.
 * WebSecurityConfigurerAdapter; import
 * org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
 * 
 * @Configuration //@EnableWebSecurity public class RestSecurityConfig extends
 * WebSecurityConfigurerAdapter {
 * 
 * @Override protected void configure(HttpSecurity http) throws Exception { http
 * .authorizeRequests() .antMatchers("/info").permitAll()
 * .antMatchers("/emp/**").hasAnyRole("USER","CLIENT") .and() .httpBasic()
 * .and() .csrf().disable(); }
 * 
 * @Bean public BCryptPasswordEncoder encoder() { return new
 * BCryptPasswordEncoder(); }
 * 
 * @Autowired public void configureGlobal(AuthenticationManagerBuilder builder)
 * throws Exception{
 * builder.inMemoryAuthentication().withUser("shantanu").password(encoder().
 * encode("welcome1")).roles("ADMIN");
 * builder.inMemoryAuthentication().withUser("john").password(encoder().encode(
 * "welcome1")).roles("USER");
 * builder.inMemoryAuthentication().withUser("vinod").password(encoder().encode(
 * "welcome1")).roles("CLIENT"); } }
 */