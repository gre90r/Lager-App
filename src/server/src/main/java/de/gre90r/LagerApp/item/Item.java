package de.gre90r.LagerApp.item;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Item {

  @Id
  private int id;
  private String name;
  private String location;
  private String description;

  public Item(int id, String name, String location, String description) {
    this.id = id;
    this.name = name;
    this.location = location;
    this.description = description;
  }

  public Item() {}

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

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
