package com.springboot.items.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.items.exception.ResourceNotFoundException;
import com.springboot.items.model.Item;
import com.springboot.items.repository.ItemRepository;
import com.springboot.items.service.ItemService;

@RestController
public class ItemController {
	
	@Autowired
	ItemService itemService;
	@Autowired
	ItemRepository itemRepository;
	
//	@PostMapping(value = "/item/add")
//	public String addItemDetails(@RequestBody Item item) {
//		int id = itemService.addItem(item);
//		return "One item Inserted and it Id --> ::"+id; 
//	}
	@PostMapping("/item/add")
	public ResponseEntity<?> addPerson(@RequestBody Item item) {
		try {
			itemService.addItem(item);
			return new ResponseEntity<Item>(item,HttpStatus.OK);
		}catch(ResourceNotFoundException e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.CONFLICT);
			
		}
	}
	
	
	@GetMapping(value = "/item/all")
	public List<Item> getAllItems(){
		
		List<Item> itemList = new ArrayList<>();
		itemList = itemService.getAllItems();
		return itemList;
	}
	
//	@GetMapping(value = "/item/{id}")
//	public Optional<Item> getRequiredItem(@PathVariable int id){
//		
//		Optional<Item> item = itemService.getRequiredItem(id);
//		return item ;
//	}
//	
	@GetMapping("/item/{id}")
	public ResponseEntity<Item> getItemById(@PathVariable(value = "id") int itemId)
			throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));
		return ResponseEntity.ok().body(item);
	}

//	@PutMapping(value = "/item/update")
//	public Item updateItemDetails(@RequestBody Item item) {
//		Item updateItem = itemService.updateItem(item);
//		return updateItem;
//	}
//	
	@PutMapping("/item/{id}")
	public ResponseEntity<Item> updateItem(@PathVariable(value = "id") int itemId,
			@Validated @RequestBody Item itemDetails) throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("item not found for this id :: " + itemId));

		
		item.setName(itemDetails.getName());
		item.setPrice(itemDetails.getPrice());
		final Item updatedItem = itemRepository.save(item);
		return ResponseEntity.ok(updatedItem);
	}

//	@DeleteMapping(value = "/item/{id}")
//	public void deleteItemById(@PathVariable int id) {
//		 itemService.deleteItemById(id);		
//	}
	@DeleteMapping("/item/{id}")
	public Map<String, Boolean> deleteItem(@PathVariable(value = "id") int itemId)
			throws ResourceNotFoundException {
		Item item = itemRepository.findById(itemId)
				.orElseThrow(() -> new ResourceNotFoundException("Item not found for this id :: " + itemId));

		itemRepository.delete(item);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
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
