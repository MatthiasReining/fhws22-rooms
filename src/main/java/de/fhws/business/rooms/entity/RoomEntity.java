package de.fhws.business.rooms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Room")
public class RoomEntity {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(max = 50)
	private String name;

	@ManyToOne
	private BuildingEntity building;

	@Min(1)
	private Integer seats;

	@NotNull
	private Integer projectors;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ChangeLogEntity> changeLog = new ArrayList<>();

	public RoomEntity() {
		// empty constructor
	}

	public RoomEntity(String name, BuildingEntity building, Integer seats, Integer projectors) {
		this.name = name;
		this.building = building;
		this.seats = seats;
		this.projectors = projectors;
	}

	public Room toDTO() {
		Room room = new Room();

		room.setId(this.getId());
		room.setName(this.getName());
		room.setProjectors(this.getProjectors());
		room.setSeats(this.getSeats());

		if (this.getBuilding() != null) {
			room.setBuildingName(this.getBuilding().getName());
		}

		return room;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<ChangeLogEntity> getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(List<ChangeLogEntity> changeLog) {
		this.changeLog = changeLog;
	}

}
