package com.nexential.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexential.crud.entity.User;
import com.nexential.crud.pageSettings.PageSettings;
import com.nexential.crud.service.UserService;
import com.nexential.crud.sort.SortSettings;

@RestController
@RequestMapping("/emp")
public class UserController {
	@Autowired
	private UserService userService;
	@PostMapping("/addUser")
	public User addUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	@PostMapping("/addUsers")
	public List<User> addUsers(@RequestBody List<User> users){
		return userService.createUsers(users);
	}
	@GetMapping("/user/{id}")
	public User getUserById(@PathVariable int id) {
		return userService.getUserById(id);
	}
	@GetMapping("/users")
	public List<User> getAllUsers(){
		return userService.getUsers();
	}

	@PutMapping("/updateuser")
	public User updateUser(@RequestBody User user) {
		return userService.updateUser(user);
	}
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable int id) {
		return userService.deleteUserById(id);
	}
	 @GetMapping("/page")
	    public Page<User> getUserPage(PageSettings pageSettings) {
	        return (Page<User>) userService.getUserPage(pageSettings);
	    }
	 @GetMapping("/sort")
	 public List<User> getPageSorted(SortSettings sortSettings){
		return userService.getPageSorted(sortSettings);
		 
	 }
	
}
