package de.gre90r.LagerApp.item;

import de.gre90r.LagerApp.location.Location;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class ItemServiceJpaImplTest {

  @Autowired
  @Qualifier("jpa")
  private ItemService itemService;

  @BeforeEach
  public void resetDb() {
    this.itemService.deleteAllItems();
  }

  public Item createTestItem() {
    final String ITEM_NAME = "pen";
    final String LAGERTYP = "basement";
    final String LAGERBEREICH = "closet 1";
    final String LAGERPLATZ = "top shelf";
    final Location LOCATION = new Location(LAGERTYP, LAGERBEREICH, LAGERPLATZ);
    final String ITEM_DESCRIPTION = "blue pen I write letters with";

    return new Item(ITEM_NAME, LOCATION, ITEM_DESCRIPTION);
  }

  /***************/
  /* getAllItems */
  /***************/
  @Test
  void getAllItems() {
    this.itemService.addItem(new Item());
    this.itemService.addItem(new Item());
    this.itemService.addItem(new Item());
    assertEquals(3, this.itemService.getAllItems().size());
  }

  /***************/
  /* getItemById */
  /***************/
  /**
   * should return the item
   */
  @Test
  void getItemById_itemExists() {
    // create item
    Item expectedItem = createTestItem();
    this.itemService.addItem(expectedItem);

    // test getItemById
    Item actualItem = this.itemService.getItemById(expectedItem.getId());
    assertNotNull(actualItem);
    assertEquals(expectedItem.getId(), actualItem.getId());
    assertEquals(expectedItem.getName(), actualItem.getName());
    assertEquals(expectedItem.getLocation().getLagerTyp(),
                 actualItem.getLocation().getLagerTyp());
    assertEquals(expectedItem.getLocation().getLagerBereich(),
                 actualItem.getLocation().getLagerBereich());
    assertEquals(expectedItem.getLocation().getLagerPlatz(),
                 actualItem.getLocation().getLagerPlatz());
    assertEquals(expectedItem.getDescription(), actualItem.getDescription());
  }

  /**
   * should not throw. returns nothing.
   */
  @Test
  void getItemById_itemDoesNotExist() {
    // guarantee DB is empty
    assertEquals(0, this.itemService.getAllItems().size());

    Assertions.assertDoesNotThrow(() -> {
      // item with id 999 does not exist
      this.itemService.getItemById(999);
    });
  }


  /******************/
  /* deleteItemById */
  /******************/
  @Test
  void deleteItemById_existingItem() {
    // create item
    Item item = createTestItem();
    this.itemService.addItem(item);
    // guarantee that item has been added successfully
    assertEquals(1, this.itemService.getAllItems().size());

    // test delete item
    this.itemService.deleteItemById(item.getId());
    assertEquals(0, this.itemService.getAllItems().size());
  }

  /**
   * should not change DB
   */
  @Test
  void deleteItemById_notExistingItem() {
    final int NUM_ITEMS = this.itemService.getAllItems().size();

    Assertions.assertDoesNotThrow(() -> {
      this.itemService.deleteItemById(123456789);
      assertEquals(NUM_ITEMS, this.itemService.getAllItems().size());
    });
  }

  /**
   * should not change DB
   */
  @Test
  void deleteItemById_negativeId() {
    final int NUM_ITEMS = this.itemService.getAllItems().size();

    Assertions.assertDoesNotThrow(() -> {
      this.itemService.deleteItemById(-1);
      assertEquals(NUM_ITEMS, this.itemService.getAllItems().size());
    });
  }

  /**************/
  /* updateItem */
  /**************/
  /**
   * should update an item, not add a new one.
   */
  @Test
  void updateItem_existingItem() {
    final int NUM_ITEMS = this.itemService.getAllItems().size();

    // add item
    Item item = createTestItem();
    this.itemService.addItem(item);
    assertEquals(NUM_ITEMS + 1, this.itemService.getAllItems().size());

    // get item
    Item actualItem = this.itemService.getItemById(item.getId());

    // update item
    actualItem.setName("gloves"); // previous name was "pen"
    this.itemService.updateItem(actualItem);

    // should still be the +1 item in DB
    assertEquals(NUM_ITEMS + 1, this.itemService.getAllItems().size());
  }

  /**
   * should not update non existing item.
   * updateItem should not add items.
   */
  @Test
  void updateItem_notExistingItem() {
    // guarantee no items are in DB
    assertEquals(0, this.itemService.getAllItems().size());

    // no items in DB, so there is nothing to update.

    Assertions.assertDoesNotThrow(() -> {
      this.itemService.updateItem(createTestItem());
    });

    // updateItem should not add an item.
    assertEquals(0, this.itemService.getAllItems().size());
  }

  /***********/
  /* addItem */
  /***********/
  /**
   * should add one item to DB
   */
  @Test
  void addItem() {
    final int NUM_ITEMS = this.itemService.getAllItems().size();
    this.itemService.addItem(new Item());
    assertEquals(NUM_ITEMS + 1, this.itemService.getAllItems().size());
  }

  /**
   * should add one item to DB
   */
  @Test
  void addItem_addDuplicate() {
    final int NUM_ITEMS = this.itemService.getAllItems().size();
    Item item = createTestItem();

    // legit add
    this.itemService.addItem(item);
    assertEquals(NUM_ITEMS + 1, this.itemService.getAllItems().size());

    // duplicate. should not add
    Assertions.assertDoesNotThrow(() -> {
      this.itemService.addItem(item);
    });

    // the same item should only be added once.
    assertEquals(NUM_ITEMS + 1, this.itemService.getAllItems().size());
  }

  /******************/
  /* deleteAllItems */
  /******************/
  @Test
  void deleteAllItems_withExistingItems() {
    // all the same items but with different id
    this.itemService.addItem(createTestItem());
    this.itemService.addItem(createTestItem());
    this.itemService.addItem(createTestItem());

    assertEquals(3, this.itemService.getAllItems().size());

    this.itemService.deleteAllItems();

    assertEquals(0, this.itemService.getAllItems().size());
  }

  @Test
  void deleteAllItems_withEmptyDb() {
    Assertions.assertDoesNotThrow(() -> {
      // guarantee empty DB
      assertEquals(0, this.itemService.getAllItems().size());

      this.itemService.deleteAllItems();
      assertEquals(0, this.itemService.getAllItems().size());
    });
  }

}