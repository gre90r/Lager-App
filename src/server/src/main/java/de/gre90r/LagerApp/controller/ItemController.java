package de.gre90r.LagerApp.controller;

import de.gre90r.LagerApp.entity.Item;
import de.gre90r.LagerApp.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/items")
public class ItemController {

  /*
    does dependency injection. Instantiates ItemService for me.
    This way it's decoupled.
   */
  @Autowired
  private ItemService itemService;

  /**
   * this is called when requesting "/items"
   * @return all items
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<Item> getAllItems() {
    return this.itemService.getAllItems();
  }

  /**
   * gets the item which is specified in the url
   * e.g. /items/1
   * @param id the id of the item to get
   * @return item which refers to the id
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Item getItemById(@PathVariable("id") int id) {
    return this.itemService.getItemById(id);
  }

  /**
   * delete on item from db by id
   * @param id id of item to delete
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteItemById(@PathVariable("id") int id) {
    this.itemService.deleteItemById(id);
  }

  /**
   * update an existing item
   * @param item the item to update
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateItem(@RequestBody Item item) {
    this.itemService.updateItem(item);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void insertItem(@RequestBody Item item) {
    this.itemService.insertItem(item);
  }
}
