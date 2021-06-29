package com.springboot.items.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.items.exception.ResourceNotFoundException;
import com.springboot.items.model.Item;

@Service
public interface ItemService {
	
	public Item addItem(Item item) throws ResourceNotFoundException;
	
	public List<Item> getAllItems();
	
	public Optional<Item>  getRequiredItem(int id);
	
	public Item updateItem(Item item);
	
    public void deleteItemById(int id);
	
	public void deleteItem(Item item);
	
	public void deleteAllItems();
	

}
