package de.gre90r.LagerApp.item;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * TODO: implement MySQL DB
 */
@Repository
@Qualifier("mySql")
public class ItemDaoMySqlImpl implements ItemDao {

  @Override
  public Collection<Item> getAllItems() {
    return null;
  }

  @Override
  public Item getItemById(int id) {
    return null;
  }

  @Override
  public void deleteItemById(int id) {

  }

  @Override
  public void updateItem(Item item) {

  }

  @Override
  public void addItem(Item item) {

  }
}
