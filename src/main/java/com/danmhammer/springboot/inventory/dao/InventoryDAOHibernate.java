package com.danmhammer.springboot.inventory.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.danmhammer.springboot.inventory.entity.Equipment;

@Repository
public class InventoryDAOHibernate implements InventoryDAO {
	
	//define field for entitymanager
	private EntityManager entityManager;
	
	//setup constructor injection 
	public InventoryDAOHibernate(EntityManager theEntityManager) {
		entityManager = theEntityManager;
	}
	
	@Override
	public List<Equipment> findAll() {
		
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query
		Query<Equipment> q = 
				currentSession.createQuery("From Equipment", Equipment.class);
		
		//execute query and get results
		List<Equipment> equipment = q.getResultList();
		
		//return results
		return equipment;
	}

	@Override
	public Equipment findById(int id) {
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//create query
		Equipment equipment = 
				currentSession.get(Equipment.class, id);
		
		return equipment;
	}

	@Override
	public void save(Equipment equipment) {
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save equipment
		//if id=0, automatically creates new equipment record. if id != 0, updates equipment with that id
		currentSession.saveOrUpdate(equipment);
		
	}

	@Override
	public void deleteById(int id) {
		//get hibernate session
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete object with id
		Query q =
				currentSession.createQuery("delete from Equipment where id=:id");
		
		//pass in id
		q.setParameter("id", id);
		
		//execute
		q.executeUpdate();
	}
	
	

}
