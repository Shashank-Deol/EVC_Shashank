
package com.tricon.evc.dao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.evc.model.ChargingStation;

/**
 * The Interface IChargingStationDao.
 */
@Repository
public interface IChargingStationDao
extends JpaRepository<ChargingStation, String> {

  /**
   * Find by name.
   *
   * @param name the name
   * @return the charging station
   */
  ChargingStation findByName(String name);
}
