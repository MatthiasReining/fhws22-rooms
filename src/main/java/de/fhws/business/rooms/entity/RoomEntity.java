package de.fhws.business.rooms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class RoomEntity {

	@Id
	@GeneratedValue
	private Long id;

	private String name;
	
	@ManyToOne
	private BuildingEntity building;
	
	private Integer seats;
	private Integer projectors;

	public RoomEntity() {
		// empty constructor
	}

	public RoomEntity(String name, BuildingEntity building, Integer seats, Integer projectors) {
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

	public BuildingEntity getBuilding() {
		return building;
	}

	public void setBuilding(BuildingEntity building) {
		this.building = building;
	}

	public Integer getProjectors() {
		return projectors;
	}

	public void setProjectors(Integer projectors) {
		this.projectors = projectors;
	}

}
