package com.Grupo10OO22021.security;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GenerarPasswordAdmin {
	
	public static void main(String[] args) {
	 BCryptPasswordEncoder passwordEncoder =  new BCryptPasswordEncoder();
	 System.out.println(passwordEncoder.encode("admin"));
  }
}
