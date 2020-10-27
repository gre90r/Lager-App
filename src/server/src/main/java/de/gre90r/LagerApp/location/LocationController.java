package de.gre90r.LagerApp.location;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/locations")
public class LocationController {

  /*
    does dependency injection. Instantiates LocationService for me.
    This way it's decoupled.
   */
  @Autowired
  @Qualifier("jpa")
  private LocationService locationService;

  /**
   * this is called when requesting "/locations"
   * @return all locations
   */
  @RequestMapping(method = RequestMethod.GET)
  public Collection<Location> getAllLocations() {
    return this.locationService.getAllLocations();
  }

  /**
   * gets the location which is specified in the url
   * e.g. /locations/1
   * @param id the id of the location to get
   * @return location which refers to the id
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  public Location getLocationById(@PathVariable("id") int id) {
    return this.locationService.getLocationById(id);
  }

  /**
   * delete location from db by id
   * @param id id of location to delete
   */
  @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
  public void deleteLocationById(@PathVariable("id") int id) {
    this.locationService.deleteLocationById(id);
  }

  /**
   * update an existing location
   * @param location the location to update
   */
  @RequestMapping(method = RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void updateLocation(@RequestBody Location location) {
    this.locationService.updateLocation(location);
  }

  @RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
  public void addLocation(@RequestBody Location location) {
    this.locationService.addLocation(location);
  }
}
