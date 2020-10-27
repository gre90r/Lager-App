package de.gre90r.LagerApp.location;

import de.gre90r.LagerApp.item.Item;
import de.gre90r.LagerApp.util.logger.Logger;
import de.gre90r.LagerApp.util.logger.LoggerImpl;
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
  public void deleteLocation(Location location) {
    try {
      this.locationRepository.delete(location);
      logger.logInfo("deleted location " + location.toString());
    } catch (Exception e) {
      logger.logWarning("location " + location.toString() + " not found. cannot delete.");
    }
  }

  @Override
  public void addLocation(Location location) {
    this.locationRepository.save(location);
    logger.logInfo("added location " + location.toString());
  }

  @Override
  public Collection<Item> getAllItemsAtLocation(Location location) {
    return this.locationRepository.findByLagerTypAndLagerBereichAndLagerPlatz(
            location.getLagerTyp(), location.getLagerBereich(), location.getLagerPlatz()
    );
  }

}
