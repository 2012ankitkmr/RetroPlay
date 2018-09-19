package retroplay.services;

import java.util.List;

import retroplay.models.MessageObject;
import retroplay.models.Playlist;
import retroplay.models.Songs;

public interface PlaylistService {

	public List<Playlist> getAllPlaylistForAUSer(String user_id) throws Exception;

	public MessageObject isSongInPlaylist(String song_id, String playlist_id) throws Exception;

	public MessageObject addToPlaylist(String song_id, String playlist_id) throws Exception;

	public List<Songs> getSongsForPlaylist(String playlist_id) throws Exception;

	public MessageObject removeSongFromPlaylist(String playlist_id, String song_id) throws Exception;

	public MessageObject removePlaylist(String playlist_id) throws Exception;

	public MessageObject createPlaylist(Playlist playlist) throws Exception;

}
