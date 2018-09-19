package retroplay.services;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import retroplay.Helper.HelperClass;
import retroplay.Helper.MessageBuilder;
import retroplay.dao.CountInfServiceDao;
import retroplay.dao.PlaylistServiceDao;
import retroplay.dao.SongsServiceDao;
import retroplay.dao.UsersServiceDao;
import retroplay.models.Count_inf;
import retroplay.models.MessageObject;
import retroplay.models.Playlist;
import retroplay.models.Songs;

@Service("playlistService")
@Transactional
public class PlaylistServiceImpl implements PlaylistService {

	@Autowired
	private PlaylistServiceDao playlistServiceDao;

	@Autowired
	private UsersServiceDao usersServiceDao;

	@Autowired
	private SongsServiceDao songsServiceDao;

	@Autowired
	private CountInfServiceDao countInfServiceDao;

	// Returns Playlists Details for a given user
	@Override
	public List<Playlist> getAllPlaylistForAUSer(String user_id) throws Exception {
		List<Playlist> allPlaylists = new ArrayList<Playlist>();
		String allPlaylistIdsStream;
		try {
			allPlaylistIdsStream = usersServiceDao.getAllPlaylistIdsForAUser(user_id);
			String playlistarray[] = allPlaylistIdsStream.split(",", 0);

			for (String playlist_id : playlistarray) {
				allPlaylists.add(playlistServiceDao.getPlaylistDetails(playlist_id));
			}
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return allPlaylists;
	}

	// Returns the status for presence of a song in a given playlist
	@Override
	public MessageObject isSongInPlaylist(String song_id, String playlist_id) throws Exception {
		MessageObject message = new MessageObject();
		String songsIdListStream;
		MessageBuilder messageBuilder = new MessageBuilder();
		try {
			songsIdListStream = playlistServiceDao.getSongsForPlaylist(playlist_id);
			String[] songsIdList = songsIdListStream.split(",",0);

			boolean flag = false;

			for (String songId : songsIdList) {
				if (songId.equals(song_id)) {
					flag = true;
				}
			}
			if (flag) {
				message = messageBuilder.buildMessageObject("Song is already Present!", true);
			} else {
				message = messageBuilder.buildMessageObject("Song is not present in the playlist!", false);
			}

			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return message;
	}

	// Add a song to a given playlist
	@Override
	public MessageObject addToPlaylist(String song_id, String playlist_id) throws Exception {
		MessageObject message = new MessageObject();
		String songIdsArray[];
		String songIdsStream = new String();
		HelperClass helperClass = new HelperClass();
		MessageBuilder messageBuilder = new MessageBuilder();
		try {

			if (isSongInPlaylist(song_id, playlist_id).isStatus()) {
				message.setMessage("Song already in playlist!!");
				message.setStatus(false);
			} else {

				if (playlistServiceDao.checkIfPlaylistExists(playlist_id) == 1) {
					songIdsStream = playlistServiceDao.getSongsForPlaylist(playlist_id);
					songIdsArray = songIdsStream.split(",",0);
					songIdsStream = helperClass.convertStringArrayToString(songIdsArray, ",");

					if (songIdsStream.length() != 0)
						songIdsStream = songIdsStream + ",";
				}

				songIdsStream = songIdsStream + song_id;
				int isAddedToPlaylist = playlistServiceDao.addToPlaylist(playlist_id, songIdsStream);

				if (isAddedToPlaylist == 1) {
					message = messageBuilder.buildMessageObject("Song added Successfully!", true);
				} else {
					message = messageBuilder.buildMessageObject("Error in adding the song!", false);
				}
			}
			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}

		return message;

	}

	// Return the list of songs for a given playlist
	@Override
	public List<Songs> getSongsForPlaylist(String playlist_id) throws Exception {
		List<Songs> allSongsForAPlayList = new ArrayList<Songs>();
		String songsIdList[];
		String songsIdsStream = new String();
		try {
			songsIdsStream = playlistServiceDao.getSongsForPlaylist(playlist_id);
			songsIdList = songsIdsStream.split(",",0);

			for (String song_id : songsIdList) {
				allSongsForAPlayList.add(songsServiceDao.getSongDetails(song_id));
			}

			// TO DO Logging
		} catch (Throwable e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return allSongsForAPlayList;

	}

	// Removes a song to a playlist
	@Override
	public MessageObject removeSongFromPlaylist(String playlist_id, String song_id) throws Exception {
		MessageObject message = new MessageObject();
		String songIdsForPlaylist[];
		HelperClass helperClass = new HelperClass();
		MessageBuilder messageBuilder = new MessageBuilder();
		String newsongIdsStream;
		String songIdsForPlaylistStream = new String();
		try {
			songIdsForPlaylistStream = playlistServiceDao.getSongsForPlaylist(playlist_id);
			songIdsForPlaylist = songIdsForPlaylistStream.split(",",0);
			String[] songIdsForPlaylistFiltered = new String[songIdsForPlaylist.length];
			int index = 0;

			for (String songId : songIdsForPlaylist) {
				if (!songId.equals(song_id)) {
					songIdsForPlaylistFiltered[index++] = songId;
				}
			}
			newsongIdsStream = helperClass.convertStringArrayToString(songIdsForPlaylistFiltered, ",");

			if (songIdsForPlaylist.length != 0) {
				int isRemovedFromPlaylist = playlistServiceDao.addToPlaylist(playlist_id, newsongIdsStream);

				if (isRemovedFromPlaylist == 1) {
					message = messageBuilder.buildMessageObject("Song removed Successfully!", true);
				} else {
					message = messageBuilder.buildMessageObject("Error in removing the song!", false);
				}
			} else {
				message = messageBuilder.buildMessageObject("Can't remove song from empty playlist!", false);
			}
			// TO DO Logging
		} catch (Throwable e) {

			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return message;

	}

	// Removes the given playlist
	@Override
	public MessageObject removePlaylist(String playlist_id) throws Exception {
		MessageObject message = new MessageObject();
		MessageBuilder messageBuilder = new MessageBuilder();
		try {
			int isRemoved = playlistServiceDao.removePlaylist(playlist_id);

			if (isRemoved == 1) {
				message = messageBuilder.buildMessageObject("Playlist removed successfully!", true);
			} else {
				message = messageBuilder.buildMessageObject("Can't remove playlist!", false);
			}
			// TO DO Logging
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return message;
	}
	
	// Creates a new playlist with given credential
	@Override
	public MessageObject createPlaylist(Playlist playlist) throws Exception {

		MessageObject message = new MessageObject();
		MessageBuilder messageBuilder = new MessageBuilder();
		Count_inf count_information = new Count_inf();
		try {

			count_information = countInfServiceDao.getCountInformation();
			int newPlaylistCount = count_information.getPlaylist_count() + 1;
			playlist.setPlaylist_id("p" + newPlaylistCount);

			int isCreated = playlistServiceDao.insertIntoPlaylist(playlist);

			if (isCreated == 1) {
				message = messageBuilder.buildMessageObject("Playlist created successfully!", true);
				countInfServiceDao.setPlaylistCountInformation(newPlaylistCount);

			} else {
				message = messageBuilder.buildMessageObject("Can't create playlist!", false);
			}
			// TO DO Logging
		} catch (Exception e) {
			// TO DO Logging
			throw new Exception(e.getMessage());
		}
		return message;

	}

}
