package com.practice.DTOLayerAndMapperLayer;

public class StudentMapper {
	
	public static Student createStudent(StudentDTO dto) {
		Student s = new Student();
		s.setName(dto.getName());
		s.setGender(dto.getGender());
		s.setCollege(dto.getCollege());
		s.setMarks(dto.getMarks());
		
		return s;
	}
	
	public static StudentDTO createStudentDTO(Student s) {
		StudentDTO dto = new StudentDTO();
		dto.setName(s.getName());
		dto.setMarks(s.getMarks());
		dto.setCollege(s.getCollege());
		dto.setGender(s.getGender());
		return dto;
		
	}
	
	
}
