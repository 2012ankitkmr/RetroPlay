package retroplay.dao;

import java.util.List;

import retroplay.models.Artists;

public interface ArtistsServiceDao {

	List<Artists> getAllArtists() throws Exception;

	Artists getArtistDetails(String artist_id) throws Exception;
	
}
