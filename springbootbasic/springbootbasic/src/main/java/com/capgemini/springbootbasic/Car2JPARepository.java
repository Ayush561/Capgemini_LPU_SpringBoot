package com.capgemini.springbootbasic;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jakarta.transaction.Transactional;

public interface Car2JPARepository extends JpaRepository<Car2, Integer> {  //JpaRepository is used to perform CRUD operations.
	
	
	//Before this we have done all the CRUD operations in DemoController but with the use of primary key(ID), now we want to search wrt price.
	public Car2 getByPrice(double price);
	//Note: the name of the method should be same as field name, you can't put getByCarPrice()- it won't work
		
	
	//If we have 2 classes ProductController and CustomerController having same endpoint then the controller will get confuse which class's endpoint to go for
	//Here we use for @RequestMapping annotation--> it is a generic mapping that will accept getMapping as well as postMapping
	
	/*
	 * @RequestMapping("/product)
	 * @RestController
	 * class ProductController{
	 * @RequestMapping("/add")
	 * public String add(Object o){
	 * 
	 * }
	 * 
	 * }
	 * Now http for product will become http://localhost:8080/product/add
	 * 
	 * 
	 * @RequestMapping("/customer")
	 * @RestController
	 * class CustomerController{
	 * 
	 * @RequestMapping("/add")
	 * public String add(Object o){
	 * 
	 * }
	 * 
	 * }
	 * http://localhost:8080/customer/add
	 */
	
	
	//We have only have methods for getBy,readBy and findBy. We don't have updateBy,deleteBy like this. because readBy,findBy,getBy don't change anything in the table
	//But DML commands change the structure of the table.
	
	//For update,delete and insert we will use this way as thing will bring changes in the table
	@Modifying
	@Transactional
	@Query("delete from Car2 c where c.brand =:carbrand")
	public int deleteByBrand(@Param("carbrand")  String brand);
	
	
	
	//If we want to use SQL query instead of JPQl then we do this way
	@Modifying
	@Transactional
	@Query(value="delete from Car2 where brand =:carbrand",nativeQuery = true)
	public int deleteByBrandSQL(@Param("carbrand")  String brand);
}
