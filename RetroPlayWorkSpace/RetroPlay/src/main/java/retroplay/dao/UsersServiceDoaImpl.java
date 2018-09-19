package retroplay.dao;

import java.util.List;
import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import retroplay.models.Users;

@Repository
public class UsersServiceDoaImpl implements UsersServiceDao {

	@PersistenceContext
	private EntityManager entityManager;

	// Fetches the no. of user with given credential
	@SuppressWarnings("unchecked")
	@Override
	public int getNoOfUsers(Users user) throws Exception {

		List<Users> result = new ArrayList<Users>();
		try {
			String hql = "FROM Users as u WHERE u.email_id=:email_id AND u.password=:password";
			Query query = entityManager.createQuery(hql);
			query.setParameter("email_id", user.getEmail_id());
			query.setParameter("password", user.getPassword());
			result = (List<Users>) query.getResultList();
			// TO DO Logging

			return result.size();
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}

	// fetches the user for a given email id
	@SuppressWarnings("unchecked")
	@Override
	public Users getUserDetails(String email_id) throws Exception {
		Users userDetails = new Users();
		List<Users> result = new ArrayList<Users>();
		try {
			String hql = "FROM Users as u WHERE u.email_id=:email_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("email_id", email_id);
			result = (List<Users>) query.getResultList();
			userDetails = result.get(0); // get the first result

			// TO DO Logging
			return userDetails;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	// fetches no. of user for a given email id
	@SuppressWarnings("unchecked")
	@Override
	public int getNoOfUsersForEmail(String email_id) throws Exception {
		List<Users> result = new ArrayList<Users>();
		try {
			String hql = "FROM Users as u WHERE u.email_id=:email_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("email_id", email_id);
			result = (List<Users>) query.getResultList();

			// TO DO Logging
			return result.size();
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	// Inserts user with user details
	@Override
	public int registerUser(Users user) throws Exception {

		try {
			String hql = "INSERT INTO Users VALUES(:user_id,:user_name,:email_id,:password,:gender,:pic_id,:playlist_ids,:dob,:phone_no)";
			Query query = entityManager.createNativeQuery(hql);

			query.setParameter("user_id", user.getUser_id());
			query.setParameter("user_name", user.getUser_name());
			query.setParameter("email_id", user.getEmail_id());
			query.setParameter("password", user.getPassword());
			query.setParameter("gender", user.getGender());
			query.setParameter("pic_id", user.getPic_id());
			query.setParameter("playlist_ids", user.getPlaylist_ids());
			query.setParameter("dob", user.getDob());
			query.setParameter("phone_no", user.getPhone_no());

			int res = query.executeUpdate();

			// TO DO Logging
			return res;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}

	// fetches all playlist Ids for a given user
	@SuppressWarnings("unchecked")
	@Override
	public String getAllPlaylistIdsForAUser(String user_id) throws Exception {
		String allPlaylistIds;
		try {
			String hql = " FROM Users WHERE user_id=:user_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("user_id", user_id);

			allPlaylistIds = (((List<Users>) query.getResultList()).get(0).getPlaylist_ids());

			return allPlaylistIds;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

}
