package com.springboot.items.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.items.model.Item;
import com.springboot.items.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	
	@PostMapping(value = "/item/add")
	public String addItemDetails(@RequestBody Item item) {
		int id = itemService.addItem(item);
		return "One item Inserted and it Id --> ::"+id; 
	}
	
	@GetMapping(value = "/item/all")
	public List<Item> getAllItems(){
		
		List<Item> itemList = new ArrayList<>();
		itemList = itemService.getAllItems();
		return itemList;
	}
	
	@GetMapping(value = "/item/{id}")
	public Optional<Item> getRequiredItem(@PathVariable int id){
		
		Optional<Item> item = itemService.getRequiredItem(id);
		return item ;
	}
	
	@PutMapping(value = "/item/update")
	public Item updateItemDetails(@RequestBody Item item) {
		Item updateItem = itemService.updateItem(item);
		return updateItem;
	}
	
	@DeleteMapping(value = "/item/{id}")
	public void deleteItemById(@PathVariable int id) {
		 itemService.deleteItemById(id);
		
	}
	
	@DeleteMapping(value = "/item/delete/all")
	public void deleteAllItems() {
		 itemService.deleteAllItems();
	}
	
	@PostMapping(value = "/delete/item")
	public void deleteItem(@RequestBody Item item) {
		 //itemsService.deleteItem(item);
		itemService.deleteItem(item);
	}



}
