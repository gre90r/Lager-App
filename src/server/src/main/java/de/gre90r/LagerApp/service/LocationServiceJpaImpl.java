package de.gre90r.LagerApp.service;

import de.gre90r.LagerApp.dao.LocationRepository;
import de.gre90r.LagerApp.entity.Location;
import de.gre90r.LagerApp.util.Logger;
import de.gre90r.LagerApp.util.LoggerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
@Qualifier("jpa")
public class LocationServiceJpaImpl implements LocationService {

  @Autowired
  private LocationRepository locationRepository;

  private final Logger logger = new LoggerImpl();

  @Override
  public Collection<Location> getAllLocations() {
    Collection<Location> locations = new ArrayList<>();
    this.locationRepository.findAll().forEach(locations::add);
    logger.logInfo("get all locations");
    return locations;
  }

  @Override
  public Location getLocationById(int id) {
    if (this.locationRepository.existsById(id)) {
      logger.logInfo("get location with id " + id);
      return this.locationRepository.findById(id).get();
    }
    logger.logWarning("location with id " + id + " not found. cannot get.");
    return null;
  }

  @Override
  public void deleteLocationById(int id) {
    if (this.locationRepository.existsById(id)) {
      this.locationRepository.deleteById(id);
      logger.logInfo("deleted location with id " + id);
    } else {
      logger.logWarning("location with id " + id + " not found. cannot delete.");
    }
  }

  @Override
  public void updateLocation(Location location) {
    if (this.locationRepository.existsById(location.getId())) {
      this.locationRepository.save(location);
      logger.logInfo("updated location with id " + location.getId());
    } else {
      logger.logWarning("location with id " + location.getId() + " not found. cannot update.");
    }
  }

  @Override
  public void addLocation(Location location) {
    if (this.locationRepository.existsById(location.getId())) {
      logger.logWarning("Location id " + location.getId() + " already exists. will not add.");
    } else {
      this.locationRepository.save(location);
    }
  }
}
