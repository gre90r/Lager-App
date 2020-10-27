package de.gre90r.LagerApp.location;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Location {

  @Id
  private int id;
  private String name;
  private String lagerTyp; // for meaning of naming refer to https://mind-logistik.de/knowhow/sap-lagerplatz-lagerbereich-und-lagertyp/
  private String lagerBereich;
  private String lagerPlatz;

  public Location(int id, String name, String lagerTyp, String lagerBereich, String lagerPlatz) {
    this.id = id;
    this.name = name;
    this.lagerTyp = lagerTyp;
    this.lagerBereich = lagerBereich;
    this.lagerPlatz = lagerPlatz;
  }

  public Location() {}

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

  public String getLagerTyp() {
    return lagerTyp;
  }

  public void setLagerTyp(String lagerTyp) {
    this.lagerTyp = lagerTyp;
  }

  public String getLagerBereich() {
    return lagerBereich;
  }

  public void setLagerBereich(String lagerBereich) {
    this.lagerBereich = lagerBereich;
  }

  public String getLagerPlatz() {
    return lagerPlatz;
  }

  public void setLagerPlatz(String lagerPlatz) {
    this.lagerPlatz = lagerPlatz;
  }
}
