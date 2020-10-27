package de.gre90r.LagerApp.location;

import java.io.Serializable;

public class LocationId implements Serializable {

  private String lagerTyp;
  private String lagerBereich;
  private String lagerPlatz;

  public LocationId() {}

  public LocationId(String lagerTyp, String lagerBereich, String lagerPlatz) {
    this.lagerTyp = lagerTyp;
    this.lagerBereich = lagerBereich;
    this.lagerPlatz = lagerPlatz;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    LocationId that = (LocationId) o;

    if (!lagerTyp.equals(that.lagerTyp)) return false;
    if (!lagerBereich.equals(that.lagerBereich)) return false;
    return lagerPlatz.equals(that.lagerPlatz);
  }

  @Override
  public int hashCode() {
    int result = lagerTyp.hashCode();
    result = 31 * result + lagerBereich.hashCode();
    result = 31 * result + lagerPlatz.hashCode();
    return result;
  }
}
