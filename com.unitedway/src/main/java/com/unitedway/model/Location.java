package com.unitedway.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Location {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(unique = true)
	private String address;
	private double latitude;
	private double longitude;
	private Relationship relationship;
	
	public Location() {
		
	}
	
	/**
	 * @param name
	 * @param address
	 * @param latitude
	 * @param longitude
	 * @param relationship
	 */
	public Location(String address, double latitude, double longitude, Relationship relationship) {
		super();
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
		this.relationship = relationship;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	public Relationship getRelationship() {
		return relationship;
	}

	public void setRelationship(Relationship relationship) {
		this.relationship = relationship;
	}
}
