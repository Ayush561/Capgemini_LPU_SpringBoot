package com.capgemini.springbootbasic;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//Now scope of Doctor is Singleton(no matter how many objects will be created, only one object will be created, if we change any attribute from one object, value of all the objects will be changed
//To handle that we use @Scope("prototype") -> this will help create any number of objects
public class Doctor {
	
	public void check() {
		System.out.println("Temp");
	}

}
