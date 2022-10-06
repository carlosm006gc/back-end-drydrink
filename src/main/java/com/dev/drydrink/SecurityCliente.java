package com.dev.drydrink;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class SecurityCliente {

	@Autowired
	private DataSource dataSource;

	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource)
				.usersByUsernameQuery(
						"select email as username, senha as password, 1 as enable from cliente where email=?")
				.authoritiesByUsernameQuery(
						"select email as username, 'cliente' as authority from cliente where email=?")
				.passwordEncoder(new BCryptPasswordEncoder());
	}

	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/index/**").authorizeRequests().anyRequest().hasAnyAuthority("cliente").and().csrf().disable()
				.formLogin().loginPage("/loginClientes").permitAll().failureUrl("/cadastrarClientes")
				.loginProcessingUrl("/loginClientes").defaultSuccessUrl("/index").usernameParameter("username")
				.passwordParameter("password").and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/index/logout")).logoutSuccessUrl("/")
				.permitAll().and().exceptionHandling().accessDeniedPage("/negado");
	}

}
