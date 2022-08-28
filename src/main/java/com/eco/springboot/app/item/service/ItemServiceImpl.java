package com.eco.springboot.app.item.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.eco.springboot.app.item.models.Item;
import com.eco.springboot.app.item.models.Producto;

@Service("clienteRestTemplate")
//se puede usar @Primary entonces se inyectaria por defecto en el que tenga primari, pero es mejor especificarlo explicito
public class ItemServiceImpl implements ItemService{

	private final Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private RestTemplate clienteRest;

	@Override
	public List<Item> findAll() {
		log.log(Level.INFO, "Uso Rest");
		List<Producto> productos = Arrays.asList(clienteRest.getForObject("http://servicio-productos/listar", Producto[].class));
		return productos.stream().map( p-> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		log.log(Level.INFO, "Uso Rest");
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Producto prod = clienteRest.getForObject("http://servicio-productos/ver/{id}", Producto.class, pathVariables);
		return new Item(prod, cantidad);
	}

}
