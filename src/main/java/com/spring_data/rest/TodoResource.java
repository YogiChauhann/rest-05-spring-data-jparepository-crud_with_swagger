package com.spring_data.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin
@RestController
public class TodoResource {

	@Autowired
	private TodoHardcodedService todoService;

	@GetMapping("/users/{username}/todos")
	public List<Todo> getAllTodos(@PathVariable String username) {
		// Thread.sleep(3000);
		return todoService.findAll();
	}

	@GetMapping("/users/{username}/todos/{id}")
	public Todo getTodo(@PathVariable String username, @PathVariable long id) {
		// Thread.sleep(3000);
		return todoService.findById(id);
	}

	// DELETE /users/{username}/todos/{id}
	@DeleteMapping("/users/{username}/todos/{id}")
	public ResponseEntity<Void> deleteTodo(@PathVariable String username, @PathVariable long id) {

		Todo todo = todoService.deleteById(id);

		if (todo != null) {
			return ResponseEntity.noContent().build();
		}

		return ResponseEntity.notFound().build();
	}
	
	@PutMapping("/users/{username}/todos/{id}")
	public  ResponseEntity<Todo> updateTodo(@PathVariable String name, 
			                                @PathVariable long id,
			                                @RequestBody Todo todo) {
		Todo todoUpdated  = todoService.save(todo);
		return new ResponseEntity<Todo>(todo, HttpStatus.OK);
	}
	
	
	
	
	
	
	
	
	
	
	

}
