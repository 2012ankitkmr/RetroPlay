package retroplay.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import retroplay.models.Artists;

@Repository
public class ArtistsServiceDaoImpl implements ArtistsServiceDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	//Fetches artist list from database 
	@SuppressWarnings("unchecked")
	@Override
	public List<Artists> getAllArtists() throws Exception {
		List<Artists> artistList =  new ArrayList<Artists>();
		try {
			String hql = "FROM Artists";
			Query query = entityManager.createQuery(hql);
			artistList = (List<Artists>) query.getResultList();
			// TO DO Logging
			return artistList;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
	}
	
	//Fetches Artist Details for a given artist id from Database
	@SuppressWarnings("unchecked")
	@Override
	public Artists getArtistDetails(String artist_id) throws Exception {

		Artists artist_details =  new Artists();
		try {
			String hql = "FROM Artists where artist_id=:artist_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("artist_id", artist_id);
			artist_details = ((List<Artists>) query.getResultList()).get(0);
			// TO DO Logging
			return artist_details;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}

	

}
