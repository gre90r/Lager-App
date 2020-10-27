package de.gre90r.LagerApp.location;

import de.gre90r.LagerApp.item.Item;

import java.util.Collection;

public interface LocationService {
  Collection<Location> getAllLocations();

  void deleteLocation(Location location);

  void addLocation(Location location);

  Collection<Item> getAllItemsAtLocation(Location location);
}
