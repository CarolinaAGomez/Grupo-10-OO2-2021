package com.Grupo10OO22021.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerarPasswordAdmin {
	
	public static void main(String[] args) {

	 BCryptPasswordEncoder passwordEncoder=  new BCryptPasswordEncoder();
	 //ENCRIPTA EL STRING ADMIN PARA LOGUEARSE CON EL USUARIO ADMIN. La pass es admin. Esto me da una clave encriptada para poner en la BD
	 System.out.println(passwordEncoder.encode("admin"));

}

}
