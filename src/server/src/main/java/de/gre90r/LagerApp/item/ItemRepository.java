package de.gre90r.LagerApp.item;

import de.gre90r.LagerApp.item.Item;
import org.springframework.data.repository.CrudRepository;

public interface ItemRepository extends CrudRepository<Item, Integer> {
  
}
