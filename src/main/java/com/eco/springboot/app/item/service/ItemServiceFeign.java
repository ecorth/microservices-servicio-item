package com.eco.springboot.app.item.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.eco.springboot.app.item.clientes.ProductoClienteRest;
import com.eco.springboot.app.item.models.Item;

@Service("clienteFeign")
public class ItemServiceFeign implements ItemService{

	private final Logger log = Logger.getLogger(this.getClass().getName());

	@Autowired
	private ProductoClienteRest clienteFeign;

	@Override
	public List<Item> findAll() {
		log.log(Level.INFO, "Uso Feign");
		return clienteFeign.findAll().stream().map(productos-> new Item(productos, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer cantidad) {
		log.log(Level.INFO, "Uso Feign");
		return new Item(clienteFeign.findById(id), cantidad);
	}

}
