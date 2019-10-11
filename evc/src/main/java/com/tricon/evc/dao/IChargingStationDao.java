package com.tricon.evc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.evc.model.ChargingStation;

@Repository
public interface IChargingStationDao extends JpaRepository<ChargingStation,String>{

}
