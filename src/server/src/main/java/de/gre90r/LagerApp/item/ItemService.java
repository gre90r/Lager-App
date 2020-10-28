package de.gre90r.LagerApp.item;

import java.util.Collection;

/**
 * defines operations on item objects
 */
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

  /**
   * updates an existing item
   * @param item the update. id of item must exist in DB
   */
  void updateItem(Item item);

  /**
   * add a new item to DB
   * @param item the item to add
   */
  void addItem(Item item);

  /**
   * deletes all items in DB.
   * Does not delete locations (TODO: test this behavior).
   */
  void deleteAllItems();
}
