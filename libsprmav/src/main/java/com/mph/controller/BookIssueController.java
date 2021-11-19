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
import com.mph.entity.BookIssue;
import com.mph.service.BookIssueService;

@RestController
@RequestMapping(value="/bookissue")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials="false",allowedHeaders="*")
public class BookIssueController {
	@Autowired
	BookIssueService bookIssueService;
	
	@GetMapping("/allbookissue")
	public ResponseEntity<List<BookIssue>> allBookIssue(){
		
		
		List<BookIssue> bissueList=bookIssueService.getBookIssueList();
		System.out.println(bissueList);
		if(bissueList.isEmpty()) {
			return new ResponseEntity<List<BookIssue>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BookIssue>>(bissueList,HttpStatus.OK);
	}
	
	@GetMapping("/bookissuebyuid")
	public ResponseEntity<List<BookIssue>> BookIssuebyuid(){
		
		
		List<BookIssue> bissueList=bookIssueService.getBookIssuebyuid();
		System.out.println(bissueList);
		if(bissueList.isEmpty()) {
			return new ResponseEntity<List<BookIssue>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<BookIssue>>(bissueList,HttpStatus.OK);
	}

	@PostMapping("/addbookIssue")
	public BookIssue createBookIssue(@RequestBody BookIssue bookIssue) {
		bookIssueService.createBookIssue(bookIssue);
		return bookIssue;
	}
	
	@PutMapping("/updatebookIssue")
	public ResponseEntity<?> updateBookIssue(@RequestBody BookIssue bookIssue){
		bookIssueService.updateBookIssue(bookIssue);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+employee.getId()+"updated successfully!");
		return new ResponseEntity<String>("updated sucessfully",HttpStatus.OK);
	}
	
	@PutMapping("/updatebookReturn")
	public ResponseEntity<?> updateBookReturn(@RequestBody BookIssue bookIssue){
		bookIssueService.updateBookReturn(bookIssue);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+employee.getId()+"updated successfully!");
		return new ResponseEntity<String>("updated sucessfully",HttpStatus.OK);
	}

	@DeleteMapping("/deletebookIssue/{isd}")
	public ResponseEntity<?> deletebookIssue(@PathVariable("isd") int id){
		bookIssueService.deleteBookIssue(id);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+id+"deleted successfully!");
		return new ResponseEntity<String>("deleted sucessfully",HttpStatus.OK);
	}

	@GetMapping("/bookIssueById/{isd}")
	public ResponseEntity<BookIssue> bookIssueById(@PathVariable("isd") int id){
		BookIssue bookIssue=bookIssueService.getBookIssueById(id);
		//System.out.println(emp);
	//	if(emp.isEmpty()) {
			//return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		//}
		return new ResponseEntity<BookIssue>(bookIssue,HttpStatus.OK);
	}	
}
