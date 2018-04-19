package com.mercury.SpringBootRestDemo.security;

import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.mercury.SpringBootRestDemo.security.handler.AccessDeniedHandlerImpl;
import com.mercury.SpringBootRestDemo.security.handler.AuthenticationEntryPointImpl;
import com.mercury.SpringBootRestDemo.security.handler.AuthenticationFailureHandlerImpl;
import com.mercury.SpringBootRestDemo.security.handler.AuthenticationSuccessHandlerImpl;
import com.mercury.SpringBootRestDemo.security.handler.LogoutSuccessHandlerImpl;

@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	AuthenticationSuccessHandlerImpl authenticationSuccessHandlerImpl;
	
	@Autowired
	AuthenticationFailureHandlerImpl authenticationFailureHandlerImpl;

	@Autowired
	AuthenticationEntryPointImpl authenticationEntryPointImpl;
	
	@Autowired
	AccessDeniedHandlerImpl accessDeniedHandlerImpl;
	
	@Autowired
	LogoutSuccessHandlerImpl logoutSuccessHandlerImpl;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		http
		.csrf().disable()//we are not protected from csrf protect cross site request forgery
		 .cors().and()
//		   .csrf()
//		       .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse())
//		       .and()
//		   .authorizeRequests()
//		      	.antMatchers(HttpMethod.GET,"/orders").hasAnyRole("ADMIN")
//		      	.antMatchers("/products").hasAnyRole("ADMIN","USER")//httppost
//		      	.and()
//		        .exceptionHandling()
//		   		.authenticationEntryPoint(authenticationEntryPointImpl)//user is not authenticated
//		   		.accessDeniedHandler(accessDeniedHandlerImpl)//user is not also authorized
//		   		.and()
//		        .formLogin()
//		              .loginProcessingUrl("/login")
//		              .usernameParameter("username")
//		              .passwordParameter("password")
//		              .successHandler(authenticationSuccessHandlerImpl)
//		              .failureHandler(authenticationFailureHandlerImpl)
//		              .and()
//		         .logout()
//		         	.logoutUrl("/logout")
//		         	.logoutSuccessHandler(logoutSuccessHandlerImpl)
//		         	.and()
		         .rememberMe();//how it working generate a new jessie cookie
//					.and()
//		         .cors();
		//hash psw for security not reversible
		//incerption psw -> decrept
	}
    @Bean
    CorsConfigurationSource corsConfigurarionSource() {
    		CorsConfiguration conf = new CorsConfiguration();
//    		conf.addAllowedOrigin("*");
  		conf.addAllowedOrigin("http://localhost:4200");
    		conf.setAllowedMethods(Arrays.asList("GET","POST","DELETE","OPTIONS"));
    		 conf.addAllowedHeader("*");
    	        conf.setAllowCredentials(true);
    	        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
    	        source.registerCorsConfiguration("/**", conf);
    	        return source;
    }
	@Bean
    public PasswordEncoder passwordEncoder() {
    	//pwd hashing
    		return new BCryptPasswordEncoder();
    }
    @Autowired
    UserDetailsService userDetailsService;
    
	@Autowired	
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		
	}
}
