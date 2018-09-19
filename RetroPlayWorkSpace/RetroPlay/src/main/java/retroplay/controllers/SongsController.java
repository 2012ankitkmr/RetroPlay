package retroplay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retroplay.models.Songs;
import retroplay.services.SongsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/songs")
public class SongsController {

	@Autowired
	private SongsService songsService;

	// Returns Song Details for a given song_id
	// I/P -->  song_id
	@RequestMapping(value = "/getDetails/{song_id}", method = RequestMethod.GET)
	public Songs getSongDetails(@PathVariable String song_id) {
		Songs song_details = new Songs();
		try {
			song_details = songsService.getSongDetails(song_id);
			// TO DO Logging
			return song_details;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}
	
	// Returns Songs Details for a given mood for a given artist
	// I/P -->  ( mood_name , artist_id )
	@RequestMapping(value = "/{mood_name}/{artist_id}", method = RequestMethod.GET)
	public List<Songs> getSongsForArtistForMood(@PathVariable String mood_name,@PathVariable String artist_id) {
		List<Songs> songs_details_forArtist_forMood = new ArrayList<Songs>();
		try {
			songs_details_forArtist_forMood = songsService.getSongForArtistForMood(mood_name,artist_id);
			// TO DO Logging
			return songs_details_forArtist_forMood;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}
	}
	
	// Returns All Songs Details
	// I/P -->  NONE
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Songs> getAllSongs() {
		List<Songs> all_songs_details = new ArrayList<Songs>();
		try {
			all_songs_details = songsService.getAllSongs();
			// TO DO Logging
			return all_songs_details;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}
	}

	
	// Returns All Songs Details for given mood
	// I/P -->  ( mood_name )
	@RequestMapping(value = "/mood/{mood_name}", method = RequestMethod.GET)
	public List<Songs> getSongsForMood(@PathVariable String mood_name) {
		List<Songs> songs_details_forMood = new ArrayList<Songs>();
		try {
			songs_details_forMood = songsService.getSongForMood(mood_name);
			// TO DO Logging
			return songs_details_forMood;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}
	}
	
	
}
