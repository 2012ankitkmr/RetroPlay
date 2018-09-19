package retroplay.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import retroplay.models.Songs;

@Repository
public class SongsSeviceDaoImpl implements SongsServiceDao {

	@PersistenceContext
	private EntityManager entityManager;

	
	// Fetches Song Details for a given song_id
	@SuppressWarnings("unchecked")
	@Override
	public Songs getSongDetails(String song_id) throws Exception {

		Songs song_details = new Songs();
		try {
			String hql = "FROM Songs WHERE song_id=:song_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("song_id", song_id);
			song_details = ((List<Songs>) query.getResultList()).get(0);
			// TO DO Logging
			return song_details;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	// fetches  all the songs details for a given mood
	@SuppressWarnings("unchecked")
	@Override
	public List<Songs> getAllSongsForGivenMood(String mood_name) throws Exception {
		List<Songs> songsArray;
		try {
			String hql = "FROM Songs where song_mood=:song_mood";
			Query query = entityManager.createQuery(hql);
			query.setParameter("song_mood", mood_name);
			songsArray = ((List<Songs>) query.getResultList());
			// TO DO Logging
			return songsArray;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}
		
	}
	
	// fetches  all the songs details
		@SuppressWarnings("unchecked")
		@Override
		public List<Songs> getAllSongs() throws Exception {
			List<Songs> songsArray;
			try {
				String hql = "FROM Songs";
				Query query = entityManager.createQuery(hql);
				songsArray = ((List<Songs>) query.getResultList());
				// TO DO Logging
				return songsArray;
			} catch (Exception e) {
				// TO DO logging
				e.printStackTrace();
				throw new Exception(e.getMessage());
			}
			
		}
	
	
	

}
