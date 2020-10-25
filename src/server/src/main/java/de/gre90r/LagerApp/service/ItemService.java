package de.gre90r.LagerApp.service;

import de.gre90r.LagerApp.dao.ItemDao;
import de.gre90r.LagerApp.entity.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class ItemService {

  @Autowired
  @Qualifier("fakeImpl") // exchange implementation here
//  @Qualifier("mySql") // exchange implementation here
  private ItemDao itemDao;

  public Collection<Item> getAllItems() {
    return this.itemDao.getAllItems();
  }

  public Item getItemById(int id) {
    return this.itemDao.getItemById(id);
  }

  public void deleteItemById(int id) {
    this.itemDao.deleteItemById(id);
  }

  public void updateItem(Item item) {
    this.itemDao.updateItem(item);
  }

  public void insertItem(Item item) {
    this.itemDao.insertItem(item);
  }
}
