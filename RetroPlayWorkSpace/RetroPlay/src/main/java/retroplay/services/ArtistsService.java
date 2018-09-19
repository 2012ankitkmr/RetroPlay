package retroplay.services;

import java.util.List;

import retroplay.models.Artists;

public interface ArtistsService {

	public List<Artists> getAllArtists() throws Exception;

	public Artists getArtistDetails(String artist_id) throws Exception;

	public List<Artists> getArtistDetailsForGivenMood(String mood_name) throws Exception;

}
