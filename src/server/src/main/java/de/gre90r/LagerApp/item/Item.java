package de.gre90r.LagerApp.item;

import de.gre90r.LagerApp.location.Location;

import javax.persistence.*;

@Entity
public class Item {

  private static int idCount = 0;

  @Id
//  @GeneratedValue(strategy = GenerationType.AUTO)
  private int id;
  private String name;
  @ManyToOne( // many items can be stored at the same location
          // do not DELETE location when deleting item. Disabled to cascade DELETE.
          cascade = { CascadeType.MERGE, CascadeType.PERSIST }
  )
  @JoinColumns({ // join columns to reference existing location, not create not allowed duplicates.
          @JoinColumn(name = "location_lagerTyp", referencedColumnName = "lagerTyp"),
          @JoinColumn(name = "location_lagerBereich", referencedColumnName = "lagerBereich"),
          @JoinColumn(name = "location_lagerPlatz", referencedColumnName = "lagerPlatz")
  })
  private Location location;
  private String description;

  /**
   * only this constructor should be used in the application, because
   * with this the id will be automatically generated.
   * @param name item name
   * @param location location where the item is stored
   * @param description item description
   */
  public Item(String name, Location location, String description) {
    this.id = idCount++;
    this.name = name;
    this.location = location;
    this.description = description;
  }

  public Item() {
    this.id = idCount++;
    this.name = "";
    this.location = new Location("", "", "");
    this.description = "";
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Location getLocation() {
    return location;
  }

  public void setLocation(Location location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
