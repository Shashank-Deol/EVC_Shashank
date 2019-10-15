
package com.tricon.evc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.evc.model.Evse;


/**
 * The Interface IEvseDao.
 */
@Repository
public interface IEvseDao extends JpaRepository<Evse, String> {


}
