package com.danmhammer.springboot.inventory.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="equipment")
public class Equipment {
	//define fields
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String name;
	@Column(name="description")
	private String description;
	@Column(name="asset_tag")
	private String assetTag;
	
	//define constructors
	public Equipment() {
		
	}

	public Equipment(String name, String description, String assetTag) {
		this.name = name;
		this.description = description;
		this.assetTag = assetTag;
	}
	
	
	
	//define getter/setter

	public Equipment(int id, String name, String description, String assetTag) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.assetTag = assetTag;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAssetTag() {
		return assetTag;
	}

	public void setAssetTag(String assetTag) {
		this.assetTag = assetTag;
	}

	//define toString
	@Override
	public String toString() {
		return "Equipment [id=" + id + ", name=" + name + ", description=" + description + ", assetTag=" + assetTag + "]";
	}		
}
