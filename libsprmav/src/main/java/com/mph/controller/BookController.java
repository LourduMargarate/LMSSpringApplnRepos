package com.mph.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.mph.entity.Book;

import com.mph.service.BookService;



@RestController
@RequestMapping(value="/book")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials="false",allowedHeaders="*")
public  class BookController {
	@Autowired
	BookService bookService;
	
	//private static final Logger logger=Logger.getLogger("EmployeeRestController.class");
	
	@GetMapping("/allbooks")
	public ResponseEntity<List<Book>> allBook(){
		
		
		List<Book> blist=bookService.getBookList();
		System.out.println(blist);
		if(blist.isEmpty()) {
			return new ResponseEntity<List<Book>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Book>>(blist,HttpStatus.OK);
	}
	

	@PostMapping("/createbook")
	public Book createBook(@RequestBody Book book) {
		bookService.createBook(book);
		return book;
	}
	
	@PutMapping("/updatebook")
	public ResponseEntity<?> updateBook(@RequestBody Book book){
		bookService.updateBook(book);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+employee.getId()+"updated successfully!");
		return new ResponseEntity<String>("updated sucessfully",HttpStatus.OK);
	}

	@DeleteMapping("/deletebook/{bid}")
	public ResponseEntity<?> deleteBook(@PathVariable("bid") int id){
		bookService.deleteBook(id);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+id+"deleted successfully!");
		return new ResponseEntity<String>("deleted sucessfully",HttpStatus.OK);
	}

	@GetMapping("/bookById/{bid}")
	public ResponseEntity<Book> bookById(@PathVariable("bid") int id){
		Book book=bookService.getBookById(id);
		//System.out.println(emp);
	//	if(emp.isEmpty()) {
			//return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		//}
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}	
	
	@GetMapping("/bookByTitle/{bTitle}")
	public ResponseEntity<Book> bookByTitle(@PathVariable("bTitle") String bname){
		Book book=bookService.getBookByTitle(bname);
		//System.out.println(emp);
	//	if(emp.isEmpty()) {
			//return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		//}
		return new ResponseEntity<Book>(book,HttpStatus.OK);
	}	
	
	
	
	
}
