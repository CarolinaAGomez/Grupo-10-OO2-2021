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
				.antMatchers("/").permitAll() //a este path puede ingresar cualquiera
				.antMatchers("/rodado/**").permitAll()
				.antMatchers("/permisodiario/**").permitAll()
				.antMatchers("/permiso/traer").permitAll()
				.antMatchers("/permiso").permitAll()
				.antMatchers("/generacionqr/**").permitAll()
				.antMatchers("/permiso/traerPorPersona/**").not().hasAuthority("ROLE_ADMIN")
				.antMatchers("/permiso/traerPorRodado/**").hasRole("AUDITOR")
				.antMatchers("/permiso/traerActivos/**").hasRole("AUDITOR")
				//EL USUARIO ADMIN NO PUEDE DAR EL ALTA, ACA CAMBIAR LUEGO PARA EL TRAER Y COLOCARLO ASI.
				.antMatchers("/permisoperiodo/**").not().hasAuthority("ROLE_ADMIN")
				.antMatchers("/persona/**").permitAll()
				.antMatchers("/auditor/**").hasRole("AUDITOR") //anyrole para poder poner mas de un rol
				.antMatchers("/usuario/**").hasRole("ADMIN") 
				.antMatchers("/perfil/**").hasRole("ADMIN") 
				.anyRequest().authenticated() //Caulquier otra url tiene que estar autenticada
			.and()
				.formLogin() //form de login
				.loginPage("/login") //va a la pagina de controller y toma la utl de login que lo llevaria a indx
				.permitAll().defaultSuccessUrl("/login/redirectMenu") //Una vez que se loguea que vaya a menu
				.failureUrl("/login?error=true")  //Si falla que vaya a la pagina de login
	            .usernameParameter("username")
	            .passwordParameter("password") //LO MISMO TIENE QUE ESTAR EN LA VISTA.-
	        .and()
	        	.logout().permitAll().logoutSuccessUrl("/");
	}
	  

}
