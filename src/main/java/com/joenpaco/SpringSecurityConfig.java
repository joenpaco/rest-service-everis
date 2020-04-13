package com.joenpaco;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.joenpaco.auth.filter.JWTAuthenticationFilter;
import com.joenpaco.auth.filter.JWTAuthorizationFilter;
import com.joenpaco.auth.services.JWTService;
import com.joenpaco.services.impl.UsuarioServiceImpl;

@EnableGlobalMethodSecurity(securedEnabled=true, prePostEnabled=true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private JWTService jwtService;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		
		return new BCryptPasswordEncoder();
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
		.anyRequest().authenticated()
		.and()
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(), jwtService))
		.csrf().disable()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.cors().and();

	}

	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception
	{
		build.userDetailsService(usuarioServiceImpl)
		.passwordEncoder(passwordEncoder());

	}
	
    @Bean
    CorsConfigurationSource corsConfigurationSource() 
    {
        CorsConfiguration configuration = new CorsConfiguration();
        configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
        configuration.setAllowedMethods(Arrays.asList("GET","POST", "PUT", "DELETE"));
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", configuration);
        return source;
    }
	
}
