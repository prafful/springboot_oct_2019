package com.example.securityconfig;


  import org.springframework.context.annotation.Configuration; import
  org.springframework.http.HttpMethod; import
  org.springframework.security.config.annotation.authentication.builders.
  AuthenticationManagerBuilder; import
  org.springframework.security.config.annotation.web.builders.HttpSecurity;
  import org.springframework.security.config.annotation.web.configuration.
  EnableWebSecurity; import
  org.springframework.security.config.annotation.web.configuration.
  WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
  
  @Configuration
  @EnableWebSecurity 
  public class SecurityConfiguration extends
  WebSecurityConfigurerAdapter{
  
  
  
  @Override 
  protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
	  
 /**
	 * Prior to Spring Security 5.0 the default PasswordEncoder was
	 * NoOpPasswordEncoder which required plain text passwords. In Spring Security
	 * 5, the default is DelegatingPasswordEncoder, which required Password Storage
	 * Format. Add password storage format, for plain text, add {noop}
	 */
		  auth.inMemoryAuthentication()
		  		.withUser("user").password("{noop}password").roles("USER") 
		  		.and() 
		  		.withUser("manager").password("{noop}password").roles("USER","MANAGER")
		  		.and()
		  		.withUser("admin").password("{noop}password").roles("USER","MANAGER","ADMIN");
		  
		  
		  }
		  
		  @Override protected void configure(HttpSecurity http) throws Exception { //
		  
		  http.authorizeRequests()
		  .antMatchers(HttpMethod.GET,"/api/**").hasAnyRole("MANAGER","ADMIN","USER")
		  .antMatchers(HttpMethod.POST, "/api/tank/add/**", "/api/tank/update/**").hasAnyRole("MANAGER","ADMIN")
		  .antMatchers(HttpMethod.DELETE, "/api/tank/delete/**").hasRole("ADMIN")
		  .and()
		  .httpBasic()
		  .and()
		  .csrf().disable();
		

		  }
		  
		  
		  
		  }
		 