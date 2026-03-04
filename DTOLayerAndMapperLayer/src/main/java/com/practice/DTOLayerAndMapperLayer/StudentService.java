package com.practice.DTOLayerAndMapperLayer;

import org.springframework.stereotype.Service;

@Service
public class StudentService {
	private StudentRepo jpa;

	public StudentService(StudentRepo jpa) {
		this.jpa = jpa;
	}
	
	public StudentDTO addStudent(StudentDTO dto) {
		Student s = StudentMapper.createStudent(dto);
		jpa.save(s);
		return StudentMapper.createStudentDTO(s);
		
	}
	
	public StudentDTO getById(int id) {
		Student s = jpa.findById(id).orElseThrow(()-> new RuntimeException("Student does not exist"));
		return StudentMapper.createStudentDTO(s);
	}
	
}
