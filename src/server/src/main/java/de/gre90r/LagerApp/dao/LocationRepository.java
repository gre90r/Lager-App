package de.gre90r.LagerApp.dao;

import de.gre90r.LagerApp.entity.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationRepository extends CrudRepository<Location, Integer> {
  
}
