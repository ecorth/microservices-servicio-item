package com.eco.springboot.app.item;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {
	//Nos permite crear obj, de spring bean y nos permite registrarlos en el contenedor
	//Es un cliente para trabajar con apirest http, para poder acceder a recursos que estan en otros microservicios
	@Bean("clienteRest")
	public RestTemplate registrarRestTemplate() {
		return new RestTemplate();
	}
}
