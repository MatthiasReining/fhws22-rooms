package de.fhws.business.rooms.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Building")
@NamedQuery(name = BuildingEntity.QUERY_BY_NAME, query = "SELECT b FROM BuildingEntity b WHERE b.name = :"
		+ BuildingEntity.PARAM_NAME)
public class BuildingEntity {

	public static final String QUERY_BY_NAME = "queryByName";
	public static final String PARAM_NAME = "name";

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

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private List<ChangeLogEntity> changeLog = new ArrayList<>();

	public BuildingEntity() {
		// empty constructor
	}

	public BuildingEntity(String name, String addressLine1, String addressLine2) {
		this.name = name;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
	}

	public Building toDTO() {
		Building building = new Building();

		building.setName(this.getName());
		building.setAddressLine1(this.getAddressLine1());
		building.setAddressLine2(this.getAddressLine2());
		return building;
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

	public List<ChangeLogEntity> getChangeLog() {
		return changeLog;
	}

	public void setChangeLog(List<ChangeLogEntity> changeLog) {
		this.changeLog = changeLog;
	}

}
