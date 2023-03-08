package com.hb.springbootrestapi.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hb.springbootrestapi.entity.Student;

@RestController
@RequestMapping("students")
public class StudentController {

	List<Student> studentList = List.of(new Student(1, "Ram", "Kumar"), new Student(2, "Shyam", "Kumar"),
			new Student(3, "Hareram", "Kumar"));

	// http://localhost:8080/student
//	@GetMapping("student")
//	public Student getStudent() {
//		Student student = new Student(1, "Hrishabh", "Kumar");
//		return student;
//	}
	
	// http://localhost:8080/student
	@GetMapping("student")
	public ResponseEntity<Student> getStudent() {
		Student student = new Student(1, "Hrishabh", "Kumar");
		return new ResponseEntity<>(student, HttpStatus.OK);
		//return ResponseEntity.ok(student);
	}

	// http://localhost:8080/students
	@GetMapping()
	public ResponseEntity<List<Student>> getStudentsList() {

		return ResponseEntity.ok(this.studentList);
	}

	// http://localhost:8080/student/1
	@GetMapping("{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable("id") int studentId) {
		Student student = this.studentList.stream().filter(a -> a.getId() == studentId).findAny().orElse(null);
		return ResponseEntity.ok(student);
	}

	// Springboot REST API with Path Variable
	// http://localhost:8080/student/5/hrishabh/bajaj
	@GetMapping("/{id}/{first-name}/{last-name}")
	public ResponseEntity<Student> studentPathVariable(@PathVariable("id") int studentId, @PathVariable("first-name") String firstName,
			@PathVariable("last-name") String lastName) {
		return ResponseEntity.ok(new Student(studentId, firstName, lastName));
	}

	// Springboot REST API with Request Param
	// http://localhost:8080/students/query?id=1&firstName=Hrishabh&lastName=Kumar
	@GetMapping("query")
	public ResponseEntity<Student> studentRequestVariable(@RequestParam int id, @RequestParam("firstName") String first_name,
			@RequestParam("lastName") String last_name) {
		return ResponseEntity.ok(new Student(id, first_name, last_name));
	}

	// Springboot REST API that handles POST request
	// http://localhost:8080/students/create
	// @@PostMapping & @@RequestBody
	@PostMapping("create")
	//@ResponseStatus(HttpStatus.CREATED) // commented because we passed the HttpStatus in return value
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		System.out.println(student.getId() + " : " + student.getFirstName() + " : " + student.getLastName());
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}

	// Springboot REST API that handles PUT request - to update existing request
	// id will be sent in URL & rest details are present in JSON
	// http://localhost:8080/students/3/update
	@PutMapping("{id}/update")
	public ResponseEntity<Student> updateStudent(@PathVariable("id") int studentId, @RequestBody Student student) {
		student.setId(studentId);
		System.out.println(student.getId() + " : " + student.getFirstName() + " : " + student.getLastName());
		return ResponseEntity.ok(student);
	}

	// Springboot REST API that handles DELETE request - to delete an existing request
	// id will be sent in URL & rest details are present in JSON
	// http://localhost:8080/students/3/delete
	@DeleteMapping("{id}/delete")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") int studentId) {
		System.out.println("Student data deleted for: "+studentId);
		return ResponseEntity.ok("Student deleted Successfully!");
		
	}

}
