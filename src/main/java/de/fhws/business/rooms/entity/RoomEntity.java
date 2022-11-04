package de.fhws.business.rooms.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class RoomEntity {

	private String name;
	private String building;
	private Integer seats;
	private Integer projectors;

	public RoomEntity() {
		// empty constructor
	}

	public RoomEntity(String name, String building, Integer seats, Integer projectors) {
		this.name = name;
		this.building = building;
		this.seats = seats;
		this.projectors = projectors;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public Integer getProjectors() {
		return projectors;
	}

	public void setProjectors(Integer projectors) {
		this.projectors = projectors;
	}

}
