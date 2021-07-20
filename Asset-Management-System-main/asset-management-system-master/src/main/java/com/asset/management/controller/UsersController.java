package com.asset.management.controller;

import java.sql.SQLException;

import java.util.List;

import com.asset.management.exceptions.EmailExistsException;
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
import org.springframework.web.bind.annotation.RestController;
import com.asset.management.entity.Users;
import com.asset.management.service.UsersService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	
	
	@GetMapping("/user")
    public List<Users> getUser()
    {
		return this.usersService.getUser();
    	
    }
	
	@GetMapping("/user/{usersId}")
	public Users getUsers(@PathVariable String usersId)
	{
		return this.usersService.getUsers(Long.parseLong(usersId));
	}

	@PostMapping("/user")
	public Users addUsers(@RequestBody Users users) throws EmailExistsException {

		String emailId = users.getEmail();
		if(emailId !=null && !"".equals(emailId)) {
			Users userObject = usersService.fetchUserByEmail(emailId);
			if(userObject != null && !userObject.getEmail().isEmpty()) {
				throw new EmailExistsException("User with "+emailId+" is already exist");
			}
		}
		return this.usersService.addUsers(users);
	}
	
	@PutMapping("/user/{usersId}")
	public Users updateUsers(@RequestBody Users users)
	{
		return this.usersService.updateUsers(users);
	}
	@DeleteMapping("/user/{usersId}")
	public ResponseEntity<HttpStatus> deleteUsers(@PathVariable String usersId){
		try {
			this.usersService.deleteUsers(Long.parseLong(usersId));
			return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
	}
	

	

}
