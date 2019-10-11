package com.tricon.evc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tricon.evc.model.GeoLocation;

@Repository
public interface IGeoLocationDao extends  JpaRepository<GeoLocation,String> {

}
