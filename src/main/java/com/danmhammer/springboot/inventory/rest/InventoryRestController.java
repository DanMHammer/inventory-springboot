package com.danmhammer.springboot.inventory.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danmhammer.springboot.inventory.entity.Equipment;
import com.danmhammer.springboot.inventory.service.InventoryService;

@RestController
@RequestMapping("/api")
public class InventoryRestController {
	
	private InventoryService inventoryService;

	public InventoryRestController(InventoryService theInventoryService) {
		inventoryService = theInventoryService;
	}
	
	//expose "/equipment" and return list of equipment
	@GetMapping("/equipment")
	public List<Equipment> findAll() {
		return inventoryService.findAll();
	}
	
	//add mapping for GET /equipment/{equipmentId}
	@GetMapping("/equipment/{equipmentId}")
	public Equipment getEmployee(@PathVariable int equipmentId) {
		Equipment equipment = inventoryService.findById(equipmentId);
		
		if (equipment == null) {
			throw new RuntimeException("Employee id not found - " + equipmentId);
		}
		
		return equipment;
	}
	
	//add mapping for POST /equipment
	@PostMapping("/equipment")
	public Equipment addEquipment(@RequestBody Equipment equipment) {
		//in case id is passed in JSON, set to 0 so it creates new equipment
		equipment.setId(0);
		
		inventoryService.save(equipment);
		
		return equipment;
	}
	
	//add mapping for PUT /equipment - update existing equipment
	@PutMapping("/equipment")
	public Equipment updateEquipment(@RequestBody Equipment equipment) {
		inventoryService.save(equipment);
		
		return equipment;
	}
	
	//add mapping for DELETE /equipment/{equipmentId}
	@DeleteMapping("/equipment/{equipmentId}")
	public String deleteEquipment(@PathVariable int equipmentId) {
		Equipment equipment = inventoryService.findById(equipmentId);
		
		//throw exception if null
		
		if(equipment==null) {
			throw new RuntimeException("Equipment id not found - " + equipmentId);
		}
		
		inventoryService.deleteById(equipmentId);
		return "Deleted equipment id - " + equipmentId;
	}
}
