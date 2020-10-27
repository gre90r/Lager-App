package de.gre90r.LagerApp.item;

import de.gre90r.LagerApp.location.Location;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

  @Test
  public void createItem() {
    // item values
    final String name = "hammer";
    final String description = "on the table";

    // location values
    final String lagerTyp = "basement";
    final String lagerBereich = "closet1";
    final String lagerPlatz = "ground";
    final Location location = new Location(lagerTyp, lagerBereich, lagerPlatz);

    Item item = new Item(name, location, description);

    // check item values
    assertTrue(item.getId() >= 0);
    assertEquals(item.getName(), name);
    assertEquals(item.getDescription(), description);
    // check location values
//    assertTrue(item.getLocation().getId() >= 0);
    assertEquals(item.getLocation().getLagerTyp(), lagerTyp);
    assertEquals(item.getLocation().getLagerBereich(), lagerBereich);
    assertEquals(item.getLocation().getLagerPlatz(), lagerPlatz);
  }

}