package de.fhws.business.rooms.entity;

public class BuildingEntity {

	private String name;
	private String addressLine1;
	private String addressLine2;

	public BuildingEntity() {
		// empty constructor
	}

	public BuildingEntity(String name, String addressLine1, String addressLine2) {
		this.name = name;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
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

}
