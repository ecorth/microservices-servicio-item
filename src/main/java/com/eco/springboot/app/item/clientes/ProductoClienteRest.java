package com.eco.springboot.app.item.clientes;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.eco.springboot.app.item.models.Producto;

@FeignClient(name = "servicio-productos")
public interface ProductoClienteRest {
	@GetMapping("/listar")
	List<Producto>findAll();

	@GetMapping("/ver/{id}")
	Producto findById(@PathVariable Long id);
}
