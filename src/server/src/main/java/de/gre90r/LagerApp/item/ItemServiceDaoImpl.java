package de.gre90r.LagerApp.item;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@Qualifier("dao")
public class ItemServiceDaoImpl implements ItemService {

  @Autowired
  @Qualifier("fakeImpl") // exchange implementation here
//  @Qualifier("mySql") // exchange implementation here
  private ItemDao itemDao;

  @Override
  public Collection<Item> getAllItems() {
    return this.itemDao.getAllItems();
  }

  @Override
  public Item getItemById(int id) {
    return this.itemDao.getItemById(id);
  }

  @Override
  public void deleteItemById(int id) {
    this.itemDao.deleteItemById(id);
  }

  @Override
  public void updateItem(Item item) {
    this.itemDao.updateItem(item);
  }

  @Override
  public void addItem(Item item) {
    this.itemDao.addItem(item);
  }

  @Override
  public void deleteAllItems() {
    // TODO: implement
  }
}
