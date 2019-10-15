
package com.tricon.evc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.evc.model.StatusSchedule;

/**
 * The Interface IStatusScheduleDao.
 */
@Repository
public interface IStatusScheduleDao
extends JpaRepository<StatusSchedule, String> {

   /**
    * Find all by period begin between.
    *
    * @param date the date
    * @param date2 the date 2
    * @return the list
    */
   List<StatusSchedule> findAllByperiodBeginBetween(Date date, Date date2);
}
