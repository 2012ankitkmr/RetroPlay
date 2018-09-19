package retroplay.dao;

import java.util.List;

import retroplay.models.Songs;

public interface SongsServiceDao {

	Songs getSongDetails(String song_id) throws Exception;

	List<Songs> getAllSongsForGivenMood(String mood_name) throws Exception;

	List<Songs> getAllSongs() throws Exception;

}
