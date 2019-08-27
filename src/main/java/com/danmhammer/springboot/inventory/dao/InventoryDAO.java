package com.danmhammer.springboot.inventory.dao;

import java.util.List;

import com.danmhammer.springboot.inventory.entity.Equipment;

public interface InventoryDAO {
	
	public List<Equipment> findAll();
	public Equipment findById(int id);
	public void save(Equipment equipment);
	public void deleteById(int id);
}
