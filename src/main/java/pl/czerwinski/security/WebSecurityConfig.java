package pl.czerwinski.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@EnableWebSecurity
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.httpBasic()
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/users","/days","/recipes").authenticated();
		
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("password")).roles("USER");
		/*auth // tu jest problem 
			.jdbcAuthentication()
			.dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery(
					"SELECT username, password, enabled from users where username = ?")
			.authoritiesByUsernameQuery(
	                "SELECT u.username, a.authority " +
	                        "FROM user_authorities a, users u " +
	                        "WHERE u.username = ? " +
	                        "AND u.id = a.user_id"
	                    );*/
		
	}

}
