package com.eco.springboot.app.item.service;

import java.util.List;

import com.eco.springboot.app.item.models.Item;

public interface ItemService {
	List<Item> findAll();
	Item findById(Long id, Integer cantidad);
}
