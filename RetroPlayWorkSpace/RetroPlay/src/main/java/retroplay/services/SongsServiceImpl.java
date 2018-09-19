package retroplay.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retroplay.dao.SongsServiceDao;
import retroplay.models.Songs;

@Service("songsService")
@Transactional
public class SongsServiceImpl implements SongsService {

	@Autowired
	private SongsServiceDao songsServiceDao;

	// Returns Song Details for a given song_id
	@Override
	public Songs getSongDetails(String song_id) throws Exception {
		Songs song_detail = new Songs();
		try {
			song_detail = songsServiceDao.getSongDetails(song_id);
			// TO DO Logging
		} catch (Throwable e) {

			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return song_detail;
	}

	// Returns Songs Details for a given mood for a given artist
	@Override
	public List<Songs> getSongForArtistForMood(String mood_name, String artist_id) throws Exception {
		List<Songs> songs_details_forArtist_forMood = new ArrayList<Songs>();
		List<Songs> songs_forGivenMood = new ArrayList<Songs>();
		try {
			if (mood_name.equals("ALL"))
				songs_forGivenMood = songsServiceDao.getAllSongs();
			else
				songs_forGivenMood = songsServiceDao.getAllSongsForGivenMood(mood_name);
			
			songs_forGivenMood.removeIf(song_list -> (!song_list.getArtist_ids().contains(artist_id)));

			songs_details_forArtist_forMood = songs_forGivenMood;
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return songs_details_forArtist_forMood;
	}

	@Override
	public List<Songs> getAllSongs() throws Exception {
		List<Songs> all_songs_details = new ArrayList<Songs>();
		try {
				all_songs_details = songsServiceDao.getAllSongs();
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return all_songs_details;
	}

	@Override
	public List<Songs> getSongForMood(String mood_name) throws Exception {	
		List<Songs> songs_forGivenMood= new ArrayList<Songs>();
		try {
			if(mood_name.equals("ALL"))
			songs_forGivenMood = songsServiceDao.getAllSongs();
			else
		songs_forGivenMood = songsServiceDao.getAllSongsForGivenMood(mood_name);
		// TO DO Logging
		}catch(Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return songs_forGivenMood;

	}

}
