package com.springboot.items.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.items.model.Item;
import com.springboot.items.repository.ItemRepository;

@Service
public class ItemServiceImpl implements ItemService{
	
	@Autowired
	ItemRepository itemRepository;
	
	public int addItem(Item item) {
		
		Item saveItem=itemRepository.insert(item);
		return saveItem.getId();
			
	}
	public List<Item> getAllItems() {

		List<Item> itemList = new ArrayList<>();
		itemList =itemRepository.findAll();
		return itemList;

	}
	public Optional<Item> getRequiredItem(int id) {

		Optional<Item> item = itemRepository.findById(id);
		return item;

	}
	
	public Item updateItem(Item item) {
		
		Item updatedItem = itemRepository.save(item);
		return updatedItem;
		
	}
    public void deleteItemById(int id) {
		
		 itemRepository.deleteById(id);
		
		
	}

    public void deleteItem(Item item) {
    	
    	itemRepository.delete(item);
	
}

    public void deleteAllItems() {
    	
    	itemRepository.deleteAll();
	
}



   }
