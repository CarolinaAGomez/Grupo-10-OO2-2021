package com.Grupo10OO22021.config;


import java.awt.image.BufferedImage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.BufferedImageHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;



@Configuration
public class qrconfig {
	

		@Bean
		public HttpMessageConverter<BufferedImage> httpMessageConverter() {
		    return new BufferedImageHttpMessageConverter();
		}
	}



