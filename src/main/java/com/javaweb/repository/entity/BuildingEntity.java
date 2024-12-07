package com.javaweb.repository.entity;

public class BuildingEntity {
	private String name;
	private String street;
	private Integer numOfStage;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public Integer getNumOFStage() {
		return numOfStage;
	}
	public void setNumOFStage(Integer numOFStage) {
		this.numOfStage = numOFStage;
	}
}
