//package com.evc.dao;
//
//import java.util.Iterator;
//import java.util.List;
//
//
//
//
//import javax.persistence.EntityManager;
//
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import com.evc.model.*;
//
//@Repository
//public class Dao  {
//	
//	@Autowired
//	private EntityManager entityManager;
//
//
//	public List<ChargingStation> get(String timeStamp) {
//		// TODO Auto-generated method stub
//		
//		Session currentSession =  entityManager.unwrap(Session.class);
//		Query<ChargingStation> query = currentSession.createQuery("from ChargingStation",ChargingStation.class);
//		List<ChargingStation> list= query.getResultList();
//		
//		
//		javax.persistence.Query q3 = entityManager.createNativeQuery(" select charging_station_id from charging_station where charging_station_id in(  select charging_station_id from evse where evse_id not in (select  evse_id from scheduled where  start_date = '2019-09-24' and start_time  between '1:00:00' and '2:00:00'))");
//		System.out.println(q3.getResultList());
//		
//		return list;
//		
//		
//	}
//
//	public void get(int id) {
//		// TODO Auto-generated method stub
//		
////		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
////		Session session = sessionFactory.getCurrentSession();
////		
////		
////		Transaction tx = session.beginTransaction();
////		SQLQuery query = session.createSQLQuery("select id, latitude from staitons");
////		List<Object[]> rows = query.list();
////		System.out.println(rows);
//
//	}
//
//	public List<Evse> getEvseList(int stationId) {
//		// TODO Auto-generated method stub
//		
//		
//		
//		return null;
//	}
//
//	public List<ChargingStationAddress> getAddressList() {
//		// TODO Auto-generated method stub
//		Session currentSession =  entityManager.unwrap(Session.class);
//		Query<ChargingStationAddress> query = currentSession.createQuery("from ChargingStationAddress",ChargingStationAddress.class);
//		List<ChargingStationAddress> addressList = query.getResultList();
//		
//		return addressList;
//	}
//
//	public ChargingStationAddress getAddress(String id) {
//		
//		javax.persistence.Query q3 = entityManager.createNativeQuery("select * from address where charging_station_id = :id");
//		q3.setParameter("id", id);
//		List<Object[]> res2 = q3.getResultList();
//		ChargingStationAddress stationAddress = new ChargingStationAddress();
//		Iterator<Object[]> it = res2.iterator();
//		Object[] line =it.next();
//		
//		stationAddress.setChargingStationId((int)line[0]);
//		stationAddress.setAddress((String)line[1]);
//		stationAddress.setPostalCode((int)line[2]);
//		stationAddress.setLatitude((String)line[3]);
//		stationAddress.setLongitude((String)line[4]);
//	
//	
//		
//		return stationAddress ;
//	}
//
//	
//
//}
