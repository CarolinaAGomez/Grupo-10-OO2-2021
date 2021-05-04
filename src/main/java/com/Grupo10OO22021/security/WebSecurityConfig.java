package com.Grupo10OO22021.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	@Autowired
	private UserDetailsService userDetails;
	
	  @Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return  new BCryptPasswordEncoder();
	  }
	
	  
	  
	//Necesario para evitar que la seguridad se aplique a los resources Como los css, imagenes y javascripts
	    String[] resources = new String[]{
	            "/include/**","/css/**","/icons/**","/img/**","/js/**","/layer/**"
	    };
	  
	  
	  //Registra el service para usuarios y el encriptador de contrasena
	  @Override
		protected void configure(AuthenticationManagerBuilder auth) throws Exception {
			 auth.userDetailsService(userDetails).passwordEncoder(passwordEncoder());     
		}

		//Que queremos que asegure y como.  
		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests() 
	        .antMatchers(resources).permitAll()  //que permita a todo lo que configure arriba
	        .antMatchers("/","/login").permitAll() //a este path puede ingresar cualquiera
	        
	        
	        /*
	        Spring security usa indistintamente hasRole()y, con hasAuthority()Spring security 4, es más consistente y también debemos ser consistentes con nuestro enfoque al usar el método hasRole()y hasAuthority(). Tengamos en cuenta las siguientes reglas simples.

	        Siempre agregue el ROLE_mientras usa el hasAuthority()método (p hasAuthority("ROLE_CUSTOMER"). Ej .).
	        Mientras lo usa hasRole(), no agregue el ROLE_prefijo, ya que Spring security ( hasRole("CUSTOMER")) lo agregará automáticamente .
	       */ 
	        
	        
	      //.antMatchers("/admin**").access("hasRole('ROLE_ADMIN')") //a todo lo que sea /admin tiene que teebr el rol de admin SOLO FUNCIONA SI LE PONGO ROLE_ADMIN EN LA BASE DE DATOS
		  // .antMatchers("/user**").access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
		  //.antMatchers("/user*").hasRole("USER") 

	        
	        .antMatchers("/user*").hasAnyRole("ADMIN","USER") //anyrole para poder poner mas de un rol
	      
	        .antMatchers("/admin*").hasRole("ADMIN") 
	       
	        
	            .anyRequest().authenticated() //Caulquier otra url tiene que estar autenticada
	            .and()
	        .formLogin() //form de login
	            .loginPage("/login") //va a la pagina de controller y toma la utl de login que lo llevaria a indx
	            .permitAll() //Ingresan todos.
	            .defaultSuccessUrl("/menu") //Una vez que se loguea que vaya a menu
	            .failureUrl("/login?error=true")  //Si falla que vaya a la pagina de login
	            .usernameParameter("username")
	            .passwordParameter("password") //LO MISMO TIENE QUE ESTAR EN LA VISTA.-
	            .and()
	        .logout()
	            .permitAll()
	            .logoutSuccessUrl("/login?logout");
	}
	  

}
