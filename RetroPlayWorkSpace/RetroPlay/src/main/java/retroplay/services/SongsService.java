package retroplay.services;

import java.util.List;

import retroplay.models.Songs;

public interface SongsService {

	public Songs getSongDetails(String song_id) throws Exception;

	public List<Songs> getSongForArtistForMood(String mood_name, String artist_id) throws Exception;

	public List<Songs> getAllSongs() throws Exception;

	public List<Songs> getSongForMood(String mood_name) throws Exception;

}
