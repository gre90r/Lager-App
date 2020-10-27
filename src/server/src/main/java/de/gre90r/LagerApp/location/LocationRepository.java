package de.gre90r.LagerApp.location;

import de.gre90r.LagerApp.item.Item;
import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

public interface LocationRepository extends CrudRepository<Location, Integer> {

  /**
   * find all items at a specific location which is defined
   * by lagerTyp, lagerBereich and lagerPlatz.
   * @param lagerTyp
   * @param lagerBereich
   * @param lagerPlatz
   * @return all items at the defined location
   */
  Collection<Item> findByLagerTypAndLagerBereichAndLagerPlatz(
          String lagerTyp, String lagerBereich, String lagerPlatz
  );

}
