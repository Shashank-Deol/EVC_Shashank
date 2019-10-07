package com.evc.dao;

import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.evc.eventhandler.UpdatedRuntimeException;
import com.evc.model.ChargingStation;
import com.evc.model.GeoLocation;

@Repository
public class DaoDemo {

	@Autowired
	private EntityManager entityManager;

	public GeoLocation getGeoLocation(String geoLocationId) {
		// TODO Auto-generated method stub
		try {
			javax.persistence.Query q3 = entityManager.createNativeQuery("select * from geo_location where id = :id");
			q3.setParameter("id", geoLocationId);
			@SuppressWarnings("unchecked")
			List<Object[]> result = q3.getResultList();

			GeoLocation geoLocationObject = new GeoLocation();
			Iterator<Object[]> it = result.iterator();
			Object[] line = it.next();
			geoLocationObject.setGeoLocationId((String) line[0]);
			geoLocationObject.setLatitude((String) line[1]);
			geoLocationObject.setLongitude((String) line[2]);

			return geoLocationObject;
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in getGeoLocation method : " + e.getLocalizedMessage(),
					e);
		}

	}

	public List<ChargingStation> get(String timeStamp) {
		// TODO Auto-generated method stub

		try {
			Session currentSession = entityManager.unwrap(Session.class);
			Query<ChargingStation> query = currentSession.createQuery("from ChargingStation", ChargingStation.class);
			List<ChargingStation> list = query.getResultList();

			return list;
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in get method : " + e.getLocalizedMessage(),
					e);
		}
	}

	public ChargingStation getStationDetails(String id) {
		// TODO Auto-generated method stub

		try {
			javax.persistence.Query q3 = entityManager.createNativeQuery("select * from location where id = :id");
			q3.setParameter("id", id);

			@SuppressWarnings("unchecked")
			List<Object[]> result = q3.getResultList();

			ChargingStation chargingStationObject = new ChargingStation();
			Iterator<Object[]> it = result.iterator();

			Object[] line = it.next();

			chargingStationObject.setId((String) line[0]);
			chargingStationObject.setName((String) line[2]);

			chargingStationObject.setAddress((String) line[4]);

			return chargingStationObject;
		} catch (Exception e) {
			throw new UpdatedRuntimeException("Exception occured in getStationDetails method: " + e.getLocalizedMessage(),
					e);
		}
	}

}
