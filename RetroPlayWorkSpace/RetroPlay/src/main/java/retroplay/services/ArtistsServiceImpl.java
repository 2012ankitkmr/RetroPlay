package retroplay.services;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retroplay.dao.ArtistsServiceDao;
import retroplay.dao.SongsServiceDao;
import retroplay.models.Artists;
import retroplay.models.Songs;

@Service("artistService")
@Transactional
public class ArtistsServiceImpl implements ArtistsService {

	@Autowired
	private ArtistsServiceDao artistServiceDao;
	
	@Autowired
	private SongsServiceDao songsServiceDao;

	// Return Artists List 
	@Override
	public List<Artists> getAllArtists() throws Exception {
		List<Artists> artistList = new ArrayList<Artists>();
		try {
			artistList = artistServiceDao.getAllArtists();
			// TO DO Logging
			return artistList;
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

	}

	//Return Artist Details for a given artist id
	@Override
	public Artists getArtistDetails(String artist_id) throws Exception {
		Artists artist_details = new Artists();
		try {
			artist_details = artistServiceDao.getArtistDetails(artist_id);
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return artist_details;
	}

	// Returns Artist Details for a given mood
	@Override
	public List<Artists> getArtistDetailsForGivenMood(String mood_name) throws Exception {
		List<Artists> artistList = new ArrayList<Artists>();
		List<Songs> songsArray = new ArrayList<Songs>();
		try {
			songsArray = songsServiceDao.getAllSongsForGivenMood(mood_name);

			Set<String> artistIdsList = new HashSet<String>();

			for (Songs currentSong : songsArray) {
				String[] artistIds = currentSong.getArtist_ids().split(",", 0);

				for (String artistId : artistIds) {
					artistIdsList.add(artistId);
				}
			}
			for(String artistId: artistIdsList) {
				artistList.add(artistServiceDao.getArtistDetails(artistId));
			}
				
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return artistList;
	}

}
