package net.najiboulhouch.spring.boot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import net.najiboulhouch.spring.boot.services.UserDetailsServiceImpl;


/**
 * @author NAJIB
 * @version 1.0 
 */
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsServiceImpl userDetailsService;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth
		.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
			
		http.formLogin().loginPage("/login.xhtml")
					.failureUrl("/login.xhtml?error=true")
					.defaultSuccessUrl("/index.xhtml", true)
					.usernameParameter("j_username")
					.passwordParameter("j_password").permitAll()
				.and()
					.logout()
					.logoutSuccessUrl("/login.xhtml")
					.deleteCookies("JSESSIONID")
					.invalidateHttpSession(true).permitAll()
				.and()
					.csrf().disable()
					.sessionManagement().sessionFixation().newSession()
				.and()
				    .authorizeRequests()
				        .anyRequest().authenticated();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/javax.faces.resource/**");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
