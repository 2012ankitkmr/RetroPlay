package retroplay.dao;

import retroplay.models.Playlist;

public interface PlaylistServiceDao {
	
	Playlist getPlaylistDetails(String playlist_id) throws Exception;

	String getSongsForPlaylist(String playlist_id) throws Exception;

	int addToPlaylist(String playlist_id, String songIdsStream) throws Exception;

	int checkIfPlaylistExists(String playlist_id) throws Exception;

	int removePlaylist(String playlist_id) throws Exception;

	int insertIntoPlaylist(Playlist playlist) throws Exception;

}
