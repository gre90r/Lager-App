package de.gre90r.LagerApp.item;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeImpl")
public class ItemDaoFakeImpl implements ItemDao {

  private static Map<Integer, Item> items;
  static {
    // test data
    items = new HashMap<Integer, Item>() {
      {
        put(1, new Item(1, "hammer", "room1", "no description"));
        put(2, new Item(2, "book", "room1", "no description"));
        put(3, new Item(3, "chair", "room1", "no description"));
      }
    };
  }

  @Override
  public Collection<Item> getAllItems() {
    return items.values();
  }

  @Override
  public Item getItemById(int id) {
    return items.get(id);
  }

  @Override
  public void deleteItemById(int id) {
    items.remove(id);
  }

  @Override
  public void updateItem(Item item) {
    items.put(item.getId(), item);
  }

  @Override
  public void addItem(Item item) {
    items.put(item.getId(), item);
  }
}
