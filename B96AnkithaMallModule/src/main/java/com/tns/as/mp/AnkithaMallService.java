
package com.tns.as.mp;

import java.util.List;//Helps to  list and its methods without needing to specify the full package path every time.


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jakarta.transaction.Transactional;

@Service //The @Service annotation is used to indicate that a class is a service component in the service layer of the application. 
@Transactional //The @Transactional annotation is used to define the scope of a transaction. It can be applied at the class or method level and ensures that a series of operations are executed within a single transaction context.
public class AnkithaMallService {
	
	@Autowired  //// It is an annotation used for automatic dependency injection
	private AnkithaMallRepository repository;
	
	public List<AnkithaMall> listAll(){
		return repository.findAll(); //the findAll() method is commonly used to retrieve all records from a database table associated with a specific entity
		
	}
	
	public AnkithaMall get(Integer id) {
		return repository.findById(id).get();	
				
				
	}
	public void save(AnkithaMall mall) {
		repository.save(mall);
		
	}
	
	public void delete(Integer id) {
		repository.deleteById(id);
	}
	


}

