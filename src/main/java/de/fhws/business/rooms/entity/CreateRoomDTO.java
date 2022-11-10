package de.fhws.business.rooms.entity;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateRoomDTO {

	@NotEmpty
	@Size(max = 50)
	private String name;

	@NotEmpty
	@Size(max = 50)
	private String buildingName;

	@Min(1)
	private Integer seats;
	@NotNull
	private Integer projectors;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public Integer getSeats() {
		return seats;
	}

	public void setSeats(Integer seats) {
		this.seats = seats;
	}

	public Integer getProjectors() {
		return projectors;
	}

	public void setProjectors(Integer projectors) {
		this.projectors = projectors;
	}

}
