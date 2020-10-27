package de.gre90r.LagerApp.location;

import de.gre90r.LagerApp.item.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/locations")
public class LocationController {

  @Autowired // instantiates LocationService for me
  @Qualifier("jpa") // choose implementation
  private LocationService locationService;

  /**
   * @return all locations
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<Location> getAllLocations() {
    return this.locationService.getAllLocations();
  }

  /**
   * add location to db
   * @param location to add
   */
  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addLocation(@RequestBody Location location) {
    this.locationService.addLocation(location);
  }

  /**
   * delete location from db by id
   * @param location to delete
   */
  @RequestMapping(method = RequestMethod.DELETE, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void deleteLocation(@RequestBody Location location) {
    this.locationService.deleteLocation(location);
  }

  /**
   * get all items which are stored at a specific location.
   * @param location where to get all items
   */
  @RequestMapping(value = "/allItemsAtLocation", method = RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
  public Collection<Item> getAllItemsAtLocation(@RequestBody Location location) {
    return this.locationService.getAllItemsAtLocation(location);
  }
}
