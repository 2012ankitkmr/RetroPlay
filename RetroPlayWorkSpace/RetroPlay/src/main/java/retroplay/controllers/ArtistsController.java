package retroplay.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retroplay.models.Artists;
import retroplay.services.ArtistsService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/artists")
public class ArtistsController {

	@Autowired
	private ArtistsService artistService;

	// Returns All Artists Information
	// I/P  -->  none
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public List<Artists> getAllArtists() {
		List<Artists> artistList = new ArrayList<Artists>();
		try {
			artistList = artistService.getAllArtists();
			// TO DO Logging
			return artistList;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}

	// Returns Artist Information for a given Artist Id
	// I/P  -->  artist_id
	@RequestMapping(value = "/{artist_id}", method = RequestMethod.GET)
	public Artists getArtistDetails(@PathVariable String artist_id) {
		Artists artist_details = new Artists();
		try {
			artist_details = artistService.getArtistDetails(artist_id);
			// TO DO Logging
			return artist_details;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}

	// Returns Artist Information list from given mood
	// I/P  -->  mood name
	@RequestMapping(value = "/mood/{mood_name}", method = RequestMethod.GET)
	public List<Artists> getArtistDetailsForGivenMood(@PathVariable String mood_name) {
		List<Artists> artistList = new ArrayList<Artists>();
		try {
			artistList = artistService.getArtistDetailsForGivenMood(mood_name);
			// TO DO Logging
			return artistList;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}

}
