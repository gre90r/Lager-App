package de.gre90r.LagerApp.dao;

import de.gre90r.LagerApp.entity.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
  
}
