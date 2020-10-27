package de.gre90r.LagerApp.location;

import de.gre90r.LagerApp.location.Location;

import java.util.Collection;

public interface LocationService {
  Collection<Location> getAllLocations();

  Location getLocationById(int id);

  void deleteLocationById(int id);

  void updateLocation(Location location);

  void addLocation(Location location);
}
