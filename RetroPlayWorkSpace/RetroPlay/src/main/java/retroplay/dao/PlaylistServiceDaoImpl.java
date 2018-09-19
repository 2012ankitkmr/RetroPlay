package retroplay.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import retroplay.models.Playlist;

@Repository
public class PlaylistServiceDaoImpl implements PlaylistServiceDao {

	@PersistenceContext
	private EntityManager entityManager;

	// Fetches playlistDetails for a given playlist_id
	@SuppressWarnings("unchecked")
	@Override
	public Playlist getPlaylistDetails(String playlist_id) throws Exception {

		Playlist playlist_details = new Playlist();
		try {
			String hql = "FROM Playlist WHERE playlist_id=:playlist_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("playlist_id", playlist_id);

			playlist_details = ((List<Playlist>) query.getResultList()).get(0);

			// TO DO Logging
			return playlist_details;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
	}

	// fetches songs list for a given playlist
	@SuppressWarnings("unchecked")
	@Override
	public String getSongsForPlaylist(String playlist_id) throws Exception {

		String songsListStream = new String();
		try {
			String hql = "FROM Playlist WHERE playlist_id=:playlist_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("playlist_id", playlist_id);

			songsListStream = ((List<Playlist>) query.getResultList()).get(0).getPlaylist_song_ids();

			// TO DO Logging
			return songsListStream;
		} catch (Exception e) {
			e.printStackTrace();
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}
	
	// Set a new song to playlist 
	@Override
	public int addToPlaylist(String playlist_id, String playlist_song_ids) throws Exception {
		try {
			String hql = "UPDATE Playlist SET playlist_song_ids=:playlist_song_ids WHERE playlist_id=:playlist_id";
			Query query = entityManager.createNativeQuery(hql);
			query.setParameter("playlist_id", playlist_id);
			query.setParameter("playlist_song_ids", playlist_song_ids);
			int res = query.executeUpdate();
			// TO DO Logging
			return res;
		} catch (Exception e) {
			// TO DO logging
			e.printStackTrace();
			throw new Exception(e.getMessage());
		}

	}
	
	// Check if playlist_id is present in playlist
	@SuppressWarnings("unchecked")
	@Override
	public int checkIfPlaylistExists(String playlist_id) throws Exception {

		try {
			String hql = "FROM Playlist WHERE playlist_id=:playlist_id";
			Query query = entityManager.createQuery(hql);
			query.setParameter("playlist_id", playlist_id);

			int isPlaylistSize = ((List<Playlist>) query.getResultList()).size();

			// TO DO Logging
			return isPlaylistSize;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
	}

	// Deletes the playlist from playlist database
	@Override
	public int removePlaylist(String playlist_id) throws Exception {
		try {
			String hql = "DELETE FROM Playlist WHERE playlist_id=:playlist_id";
			Query query = entityManager.createNativeQuery(hql);
			query.setParameter("playlist_id", playlist_id);
			int res = query.executeUpdate();
			// TO DO Logging
			return res;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

	// Inserts a new playlist with details into the playlist database
	@Override
	public int insertIntoPlaylist(Playlist playlist) throws Exception {
		try {
			String hql = "INSERT INTO Playlist VALUES(:playlist_id,:playlist_name,'')";
			Query query = entityManager.createNativeQuery(hql);
			query.setParameter("playlist_id", playlist.getPlaylist_id());
			query.setParameter("playlist_name", playlist.getPlaylist_name());
			int res = query.executeUpdate();
			// TO DO Logging
			return res;
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

}
