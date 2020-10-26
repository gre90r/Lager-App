package de.gre90r.LagerApp.dao;

import de.gre90r.LagerApp.entity.Item;

import java.util.Collection;

public interface ItemDao {
  Collection<Item> getAllItems();

  Item getItemById(int id);

  void deleteItemById(int id);

  void updateItem(Item item);

  void addItem(Item item);
}
