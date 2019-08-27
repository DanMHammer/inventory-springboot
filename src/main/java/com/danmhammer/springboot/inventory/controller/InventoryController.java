package com.danmhammer.springboot.inventory.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.danmhammer.springboot.inventory.entity.Equipment;
import com.danmhammer.springboot.inventory.service.InventoryService;

@Controller
@RequestMapping("/inventory")
public class InventoryController {
	
	private InventoryService  inventoryService;
	
	public InventoryController(InventoryService theInventoryService) {
		inventoryService = theInventoryService;
	}
	//create mapping for "/list"
	@GetMapping("/list")
	public String listEquipment(Model theModel) {
		List<Equipment> equipmentList = inventoryService.findAll();
		theModel.addAttribute("equipment", equipmentList);
		
		return "list-equipment";
	}
	
	//mapping for "/showAddEquipment
	@GetMapping("/showAddEquipment")
	public String showAddEquipment(Model theModel) {
		//create equipment to pass into form
		Equipment equipment = new Equipment();
		
		//add to model
		theModel.addAttribute("equipment", equipment);
		
		//show template
		return "equipment-form";
	}
	
	@GetMapping("/showUpdateEquipment")
	public String showUpdateEquipment(@RequestParam("equipmentId") int id, Model theModel) {
		//get equipment from service
		Equipment equipment = inventoryService.findById(id);
		//add to model to prepopulate form
		theModel.addAttribute("equipment", equipment);
		//show template
		return "equipment-form";
	}
	
	@GetMapping("/delete")
	public String showUpdateEquipment(@RequestParam("equipmentId") int id) {
		//delete equipment
		inventoryService.deleteById(id);
		//redirect back to list
		return "redirect:/inventory/list";
	}
	
	
	@PostMapping("/save")
	public String saveEquipment(@ModelAttribute("equipment") Equipment theEquipment) {
		//save the equipment
		inventoryService.save(theEquipment);
		//redirect back to list
		return "redirect:/inventory/list";
	}
}
