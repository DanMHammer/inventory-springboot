package com.danmhammer.springboot.inventory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.danmhammer.springboot.inventory.dao.InventoryDAO;
import com.danmhammer.springboot.inventory.entity.Equipment;

@Service
public class InventoryServiceImplementation implements InventoryService {
	
	private InventoryDAO inventoryDAO;
	
	public InventoryServiceImplementation (InventoryDAO theInventoryDAO) {
		inventoryDAO = theInventoryDAO;
	}
	
	@Override
	@Transactional
	public List<Equipment> findAll() {
		return inventoryDAO.findAll();
	}

	@Override
	@Transactional
	public Equipment findById(int id) {
		return inventoryDAO.findById(id);
	}

	@Override
	@Transactional
	public void save(Equipment equipment) {
		inventoryDAO.save(equipment);
	}

	@Override
	@Transactional
	public void deleteById(int id) {
		inventoryDAO.deleteById(id);
	}

}
