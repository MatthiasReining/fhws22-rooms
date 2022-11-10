package de.fhws.business.rooms.entity;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class BuildingEntity {

	@Id
	@GeneratedValue
	private Long id;

	@NotEmpty
	@Size(max = 50)
	private String name;
	@NotEmpty
	@Size(max = 400)
	private String addressLine1;
	@NotEmpty
	@Size(max = 400)
	private String addressLine2;

	private LocalDateTime createdAt;

	public BuildingEntity() {
		// empty constructor
	}

	public BuildingEntity(String name, String addressLine1, String addressLine2) {
		this.name = name;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	public BuildingDTO toDTO() {
		BuildingDTO building = new BuildingDTO();

		building.setName(this.getName());
		building.setAddressLine1(this.getAddressLine1());
		building.setAddressLine2(this.getAddressLine2());
		return building;
	}

	@PrePersist
	public void preSave() {
		if (this.createdAt == null)
			this.createdAt = LocalDateTime.now();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

}
