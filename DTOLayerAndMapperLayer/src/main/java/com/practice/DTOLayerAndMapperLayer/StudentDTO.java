package com.practice.DTOLayerAndMapperLayer;

public class StudentDTO {

	//In DTO layer we will only provide the necessary details, like abstraction, the hidden data wouldn't be shown in the DTO as it needs to be kept hidden
	//DTO layer will now work with DB and not API, Earlier API was directly communicating with the DB but it is not a good practice, there should be layer which should be the medium between API and DB
	//And to create an entity to DTO we will use Mapper.
	
	
	
	private String name;
	private String college;
	private String gender;
	private double marks;
	
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCollege() {
		return college;
	}
	public void setCollege(String college) {
		this.college = college;
	}
	public double getMarks() {
		return marks;
	}
	public void setMarks(double marks) {
		this.marks = marks;
	}
	
}
