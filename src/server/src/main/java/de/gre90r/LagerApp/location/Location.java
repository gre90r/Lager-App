package de.gre90r.LagerApp.location;

import de.gre90r.LagerApp.item.Item;

import javax.persistence.*;
import java.util.Collection;

@Entity
@IdClass(LocationId.class) // needed because of multiple primary keys
@Table(name = "location")
public class Location {

  @Id
  private final String lagerTyp; // for meaning of naming refer to https://mind-logistik.de/knowhow/sap-lagerplatz-lagerbereich-und-lagertyp/
  @Id
  private final String lagerBereich;
  @Id
  private final String lagerPlatz;
  // one location stores many items
  @OneToMany(
          targetEntity = Item.class,
          mappedBy = "location"
//          // location should be preserved after item has been deleted, so do not cascade on DELETE
//          cascade = { CascadeType.MERGE, CascadeType.PERSIST }
  )
  private Collection<Item> items;

  public Location(String lagerTyp, String lagerBereich, String lagerPlatz) {
    this.lagerTyp = lagerTyp;
    this.lagerBereich = lagerBereich;
    this.lagerPlatz = lagerPlatz;
  }

  public Location() {
    this.lagerTyp = "";
    this.lagerBereich = "";
    this.lagerPlatz = "";
  }

  public String getLagerTyp() {
    return this.lagerTyp;
  }

  public String getLagerBereich() {
    return this.lagerBereich;
  }

  public String getLagerPlatz() {
    return this.lagerPlatz;
  }

  @Override
  public String toString() {
    return "{" + this.lagerTyp + ", " + this.lagerBereich + ", " +  this.lagerPlatz + "}";
  }
}
