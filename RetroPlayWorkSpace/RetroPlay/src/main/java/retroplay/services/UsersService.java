package retroplay.services;

import retroplay.models.MessageObject;
import retroplay.models.Users;

public interface UsersService {

	public MessageObject isValidUser(Users user) throws Exception;

	public Users getUserDetails(String email_id) throws Exception;

	public MessageObject isAlreadyRegisteredUser(String email_id) throws Exception;

	public MessageObject registerUser(Users user) throws Exception;

}
