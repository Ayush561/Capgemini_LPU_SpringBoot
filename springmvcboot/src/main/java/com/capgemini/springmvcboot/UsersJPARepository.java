package com.capgemini.springmvcboot;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersJPARepository extends JpaRepository<Users, String>{
	
	public Users findByEmailAndPassword(String email,String password);

}
