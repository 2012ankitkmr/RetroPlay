package retroplay.dao;

import retroplay.models.Users;

public interface UsersServiceDao {

	String getAllPlaylistIdsForAUser(String user_id) throws Exception;

	int getNoOfUsers(Users user) throws Exception;

	Users getUserDetails(String email_id) throws Exception;

	int getNoOfUsersForEmail(String email_id) throws Exception;

	int registerUser(Users user) throws Exception;

}
