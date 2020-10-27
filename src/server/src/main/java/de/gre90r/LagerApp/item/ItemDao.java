package de.gre90r.LagerApp.item;

import de.gre90r.LagerApp.item.Item;

import java.util.Collection;

public interface ItemDao {
  Collection<Item> getAllItems();

  Item getItemById(int id);

  void deleteItemById(int id);

  void updateItem(Item item);

  void addItem(Item item);
}
