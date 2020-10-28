package de.gre90r.LagerApp.item;

import java.util.Collection;

public interface ItemService {
  Collection<Item> getAllItems();

  /**
   * search for item by id in DB
   * @param id id of item to get
   * @return item if exists. returns null if not exists
   */
  Item getItemById(int id);

  /**
   * search item by id in DB and delete it
   * @param id delete item with this id
   */
  void deleteItemById(int id);

  void updateItem(Item item);

  void addItem(Item item);

  void deleteAllItems();
}
