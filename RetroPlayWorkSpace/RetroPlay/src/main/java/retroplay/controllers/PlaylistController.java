package retroplay.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import retroplay.models.MessageObject;
import retroplay.models.Playlist;
import retroplay.models.Songs;
import retroplay.services.PlaylistService;

@RestController
@RequestMapping(value = "/playlist")
public class PlaylistController {

	@Autowired
	private PlaylistService playlistService;

	// Returns Playlists Details for a given user
	// I/P --> user_id
	@RequestMapping(value = "/getAllPlaylistsForAUser/{user_id}", method = RequestMethod.GET)
	public List<Playlist> getAllPlaylistsForAUser(@PathVariable String user_id) {
		List<Playlist> allPlaylists = new ArrayList<Playlist>();
		try {
			allPlaylists = playlistService.getAllPlaylistForAUSer(user_id);
			// TO DO Logging
			return allPlaylists;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}
	}

	// Returns the status for presence of a song in a given playlist
	// I/P --> (playlist_id , song_id)
	@RequestMapping(value = "/isSongInPlaylist", method = RequestMethod.POST)
	public MessageObject isSongInPlaylist(@RequestBody Map<String, String> json) {
		MessageObject message = new MessageObject();
		String playlist_id = json.get("playlist_id");
		String song_id = json.get("song_id");
		try {

			message = playlistService.isSongInPlaylist(song_id, playlist_id);
			// TO DO Logging
			return message;
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}

	}

	// Add a song to a given playlist
	// I/P --> ( playlist_id , song_id )
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public MessageObject addToPlaylist(@RequestBody Map<String, String> json) {
		MessageObject message = new MessageObject();
		String playlist_id = json.get("playlist_id");
		String song_id = json.get("song_id");
		try {
			message = playlistService.addToPlaylist(song_id, playlist_id);
			// TO DO Logging
			return message;
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
	}

	// Return the list of songs for a given playlist
	// I/P --> playlist_id
	@RequestMapping(value = "/songs/{playlist_id}", method = RequestMethod.GET)
	public List<Songs> getSongsForPlaylist(@PathVariable String playlist_id) {
		List<Songs> songsList = new ArrayList<Songs>();

		try {
			songsList = playlistService.getSongsForPlaylist(playlist_id);
			// TO DO Logging
			return songsList;
		} catch (Throwable e) {
			// TO DO Logging
			return null;
		}
	}

	// Removes a song to a playlist
	// I/P --> ( playlist_id , song_id)
	@RequestMapping(value = "/remove", method = RequestMethod.POST)
	public MessageObject removeSongFromPlaylist(@RequestBody Map<String, String> json) {
		MessageObject messageObject = new MessageObject();
		String playlist_id = json.get("playlist_id");
		String song_id = json.get("song_id");
		try {
			messageObject = playlistService.removeSongFromPlaylist(playlist_id, song_id);
			// TO DO Logging
			return messageObject;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}

	// Removes the given playlist
	// I/P --> ( playlist_id )
	@RequestMapping(value = "/removePlaylist", method = RequestMethod.POST)
	public MessageObject removePlaylist(@RequestBody Map<String, String> json) {
		MessageObject messageObject = new MessageObject();
		String playlist_id = json.get("playlist_id");
		try {
			messageObject = playlistService.removePlaylist(playlist_id);
			// TO DO Logging
			return messageObject;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}

	// Creates a new playlist with given credential
	// I/P --> ( playlist details specifically playlist name )
	@RequestMapping(value = "/createPlaylist", method = RequestMethod.POST)
	public MessageObject createPlaylist(@RequestBody Playlist playlist) {
		MessageObject messageObject = new MessageObject();

		try {
			messageObject = playlistService.createPlaylist(playlist);
			// TO DO Logging
			return messageObject;
		} catch (Exception e) {
			// TO DO Logging
			return null;
		}

	}

}
