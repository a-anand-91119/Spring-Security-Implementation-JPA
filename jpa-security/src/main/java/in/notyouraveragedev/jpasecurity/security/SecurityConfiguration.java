package in.notyouraveragedev.jpasecurity.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import in.notyouraveragedev.jpasecurity.service.MyUserDetailsSerivce;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private MyUserDetailsSerivce myUserDetailsSerivce;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// as for the authentication part, unlike JDBC spring doesn't have an out of the box
		// implementation for JPA that you can use.
		// for jpa we need to have out own implementation for UserDetailsService and return a UserDetails
		// Read through blog post on spring security for more details
		
		auth.userDetailsService(myUserDetailsSerivce);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// the authorities / authorization part
		http.authorizeRequests().antMatchers("/").hasRole("USER").and().formLogin();
	}

}
