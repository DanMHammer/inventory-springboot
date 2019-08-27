package com.danmhammer.springboot.inventory.service;

import java.util.List;

import com.danmhammer.springboot.inventory.entity.Equipment;

public interface InventoryService {
	
	public List<Equipment> findAll();
	public Equipment findById(int id);
	public void save(Equipment equipment);
	public void deleteById(int id);
	
}
