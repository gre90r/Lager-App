package de.gre90r.LagerApp.item;

import de.gre90r.LagerApp.util.logger.Logger;
import de.gre90r.LagerApp.util.logger.LoggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Qualifier("jpa")
public class ItemServiceJpaImpl implements ItemService {

  @Autowired
  private ItemRepository itemRepository;

  private final Logger logger = new LoggerImpl();

  @Override
  public Collection<Item> getAllItems() {
    Collection<Item> items = new ArrayList<>();
    this.itemRepository.findAll().forEach(items::add);
    logger.logInfo("get all items");
    return items;
  }

  @Override
  public Item getItemById(int id) {
    if (this.itemRepository.existsById(id)) {
      logger.logInfo("get item with id " + id);
      return this.itemRepository.findById(id).get();
    }
    logger.logWarning("item with id " + id + " not found. cannot get.");
    return null;
  }

  @Override
  public void deleteItemById(int id) {
    if (this.itemRepository.existsById(id)) {
      this.itemRepository.deleteById(id);
      logger.logInfo("deleted item with id " + id);
    } else {
      logger.logWarning("item with id " + id + " not found. cannot delete.");
    }
  }

  @Override
  public void updateItem(Item item) {
    if (this.itemRepository.existsById(item.getId())) {
      this.itemRepository.save(item);
      logger.logInfo("updated item with id " + item.getId());
    } else {
      logger.logWarning("item with id " + item.getId() + " not found. cannot update.");
    }
  }

  @Override
  public void addItem(Item item) {
    if (this.itemRepository.existsById(item.getId())) {
      logger.logWarning("Item id " + item.getId() + " already exists. will not add.");
    } else {
      this.itemRepository.save(item);
      logger.logInfo("added item with id " + item.getId());
    }
  }

  @Override
  public void deleteAllItems() {
    this.itemRepository.deleteAll();
  }
}
