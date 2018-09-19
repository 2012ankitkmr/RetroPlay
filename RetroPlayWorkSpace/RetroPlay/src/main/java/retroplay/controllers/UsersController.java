package retroplay.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retroplay.models.MessageObject;
import retroplay.models.Users;
import retroplay.services.UsersService;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

	@Autowired
	private UsersService userService;

	// Returns the status if the user is valid
	// I/P  -->   ( userDetails--> ( email_id , password ) )
	@RequestMapping(value = "/isValidUser", method = RequestMethod.POST)
	public MessageObject isValidUser(@RequestBody Users user) {
		MessageObject message = new MessageObject();
		try {
			message = userService.isValidUser(user);
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
		return message;
	}
	
	// Returns the User Details for a given email_id
	// I/P  -->   email_id
	@RequestMapping(value = "/getUserDetails/{email_id}", method = RequestMethod.GET)
	public Users getUserDetails(@PathVariable String email_id) {
		Users userDetails = new Users();
		try {
			userDetails = userService.getUserDetails(email_id);
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
		return userDetails;
	}
	
	// Returns If the user is already registered
	// I/P  -->   email_id
	@RequestMapping(value = "/isAlreadyRegistered/{email_id}", method = RequestMethod.GET)
	public MessageObject isAlreadyRegisteredUser(@PathVariable String email_id) {
		MessageObject message = new MessageObject();
		try {
			System.out.println(email_id);
			message = userService.isAlreadyRegisteredUser(email_id);
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
		return message;
	}
	
	// Returns If the user is registered
	// I/P  -->   User Details 
	@RequestMapping(value = "/registerUser", method = RequestMethod.POST)
	public MessageObject registerUser(@RequestBody Users user) {
		MessageObject message = new MessageObject();
		try {
			message = userService.registerUser(user);
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
		return message;
	}
	
}
