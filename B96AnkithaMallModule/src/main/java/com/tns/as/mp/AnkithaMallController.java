package com.tns.as.mp;

import java.util.List; //Helps to  list and its methods without needing to specify the full package path every time.

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
//This API is combination of Controller and Response body helpful to handle HTTP request and returns objects to json or Xml
public class AnkithaMallController {
	
	@Autowired
	// It is an annotation used for automatic dependency injection
	private AnkithaMallService service;
	
	
	//Retrieval
	@GetMapping("/mall") // handle HTTP GET request
	public List<AnkithaMall> list(){
		return service.listAll();
		
	}
	
	//Retrieve By Id
	@GetMapping("/mall/{id}")  //handle HTTP GET reques
	public ResponseEntity<AnkithaMall> get(@PathVariable Integer id){
		try {
			AnkithaMall mall =service.get(id);
			return new ResponseEntity<AnkithaMall>(mall,HttpStatus.OK);
		} 
		catch (Exception e) {
			return new ResponseEntity<AnkithaMall>(HttpStatus.NOT_FOUND);
			//try-catch blocks are used for exception handling. 
			
		}
		
		
	}
	//Create
	@PostMapping("/mall")  //annotation used to handle HTTP POST requests in a RESTful web service
	public void add(@RequestBody AnkithaMall mall) {
		service.save(mall);
	}
	
	//Update
	@PutMapping("/mall/{id}") //to handle HTTP PUT requests
	
	public ResponseEntity<?> update(@RequestBody AnkithaMall mall,@PathVariable Integer id){
		try {
			AnkithaMall  existMall = service.get(id);
			service.save(mall);
			return new ResponseEntity <> (HttpStatus.OK);
		} 
		catch (Exception e) {
			
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	//Delete 
	@DeleteMapping("/mall/{id}")  // to handle HTTP DELETE requests
	public void dlete(@PathVariable Integer id) {
		service.delete(id);
	}
	
	//CRUD (Create, Read, Update, Delete) application in Spring Boot is a common use case for managing resources. 
			

}
