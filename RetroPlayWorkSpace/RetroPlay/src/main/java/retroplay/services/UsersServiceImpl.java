package retroplay.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retroplay.Helper.MessageBuilder;
import retroplay.dao.UsersServiceDao;
import retroplay.models.MessageObject;
import retroplay.models.Users;
import javax.transaction.Transactional;

@Service("userService")
@Transactional
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersServiceDao userServiceDao;
	
	// Returns the status if the user is valid
	@Override
	public MessageObject isValidUser(Users user) throws Exception {
		MessageObject message = new MessageObject();
		MessageBuilder messageBuilder = new MessageBuilder();
		try {
			int noOfUsers = userServiceDao.getNoOfUsers(user);

			if (noOfUsers >= 1) {
				message = messageBuilder.buildMessageObject("Successfully Logged In!", true);
			} else {
				message = messageBuilder.buildMessageObject("Incorrect Email or Password!", false);
			}
			// TO DO Logging
			return message;
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
	}

	// Returns the User Details for a given email_id
	@Override
	public Users getUserDetails(String email_id) throws Exception {

		Users userDetails = new Users();
		try {
			userDetails = userServiceDao.getUserDetails(email_id);
			return userDetails;
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

	// Returns If the user is already registered
	@Override
	public MessageObject isAlreadyRegisteredUser(String email_id) throws Exception {
		MessageObject message = new MessageObject();
		MessageBuilder messageBuilder = new MessageBuilder();
		try {
			int noOfUsers = userServiceDao.getNoOfUsersForEmail(email_id);

			if (noOfUsers >= 1) {
				message = messageBuilder.buildMessageObject("Already Registered!", true);
			} else {
				message = messageBuilder.buildMessageObject("Not Registered!", false);
			}
			// TO DO Logging
			return message;
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
	}

	// Registers the user 
	@Override
	public MessageObject registerUser(Users user) throws Exception {
		MessageObject message = new MessageObject();
		MessageBuilder messageBuilder = new MessageBuilder();

		try {
			int isInserted = userServiceDao.registerUser(user);

			if (isInserted == 1) {
				message = messageBuilder.buildMessageObject("Registered Successfully!", true);
			} else {
				message = messageBuilder.buildMessageObject("An Unexpected Error Occured.Please write to us!", false);
			}

			return message;
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
	}

}
