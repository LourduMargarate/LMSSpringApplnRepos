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

import com.mph.entity.BookIssue;
import com.mph.entity.LibraryUser;
import com.mph.service.BookIssueService;
import com.mph.service.LibraryUserService;

@RestController
@RequestMapping(value="/user")
@CrossOrigin(origins = "http://localhost:4200",methods = {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE},allowCredentials="false",allowedHeaders="*")
public class LibraryUserController {
	@Autowired
	LibraryUserService libraryUserService;
	
	/**
	 * allUsers() is a method to fetch the list of users from database
	 * @return
	 */
	@GetMapping("/allusers")
	public ResponseEntity<List<LibraryUser>> allUsers(){
		
		
		List<LibraryUser> uList=libraryUserService.getLibraryUserList();
		System.out.println(uList);
		if(uList.isEmpty()) {
			return new ResponseEntity<List<LibraryUser>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LibraryUser>>(uList,HttpStatus.OK);
	}
	

	/**
	 * createUser(@RequestBody LibraryUser libraryUser) is a method to add users to database
	 * @param libraryUser
	 * @return
	 */
	@PostMapping("/addusers")
	public LibraryUser createUser(@RequestBody LibraryUser libraryUser) {
		libraryUserService.createLibraryUser(libraryUser);
		return libraryUser;
	}
	
	/**
	 * updateUser(@RequestBody LibraryUser libraryUser) is a method to update users from database
	 * @param libraryUser
	 * @return
	 */
	@PutMapping("/updateUser")
	public ResponseEntity<?> updateUser(@RequestBody LibraryUser libraryUser){
		libraryUserService.updateLibraryUser(libraryUser);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+employee.getId()+"updated successfully!");
		return new ResponseEntity<String>("updated sucessfully",HttpStatus.OK);
	}

	/**
	 * deleteUser(@PathVariable("uid") int id) is a method to delete users by userid from database
	 * @param id
	 * @return
	 */
	@DeleteMapping("/deleteUser/{uid}")
	public ResponseEntity<?> deleteUser(@PathVariable("uid") int id){
		libraryUserService.deleteLibraryUser(id);
		//List<Employee> emplist=employeeService.getAllEmployee();
		//return ResponseEntity.ok().body("New Employee with ID"+id+"deleted successfully!");
		return new ResponseEntity<String>("deleted sucessfully",HttpStatus.OK);
	}


	/**
	 * userById(@PathVariable("uid") int id)  is a method to fetch user by userid from database
	 * @param id
	 * @return
	 */
	@GetMapping("/userById/{uid}")
	public ResponseEntity<LibraryUser> userById(@PathVariable("uid") int id){
		LibraryUser user=libraryUserService.getLibraryUserById(id);
		//System.out.println(emp);
	//	if(emp.isEmpty()) {
			//return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		//}
		return new ResponseEntity<LibraryUser>(user,HttpStatus.OK);
	}
	
	/**
	 * userByName(@PathVariable("uname") String name)  is a method to fetch user by name from database
	 * @param name
	 * @return
	 */
	@GetMapping("/userByName/{uname}")
	public ResponseEntity<LibraryUser> userByName(@PathVariable("uname") String name){
		LibraryUser user=libraryUserService.getLibraryUserByName(name);
		//System.out.println(emp);
	//	if(emp.isEmpty()) {
			//return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
		//}
		return new ResponseEntity<LibraryUser>(user,HttpStatus.OK);
	}	
}
