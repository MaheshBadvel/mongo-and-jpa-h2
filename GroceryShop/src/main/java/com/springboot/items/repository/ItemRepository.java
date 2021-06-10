package com.springboot.items.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.springboot.items.model.Item;

@Repository
public interface ItemRepository extends MongoRepository<Item, Integer> {

}
