package retroplay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Playlist")
public class Playlist {

	@Id
	@Column(name = "playlist_id")
	private String playlist_id;

	@Column(name = "playlist_name")
	private String playlist_name;

	@Column(name = "playlist_song_ids")
	private String playlist_song_ids;

	public String getPlaylist_id() {
		return playlist_id;
	}

	public void setPlaylist_id(String playlist_id) {
		this.playlist_id = playlist_id;
	}

	public String getPlaylist_name() {
		return playlist_name;
	}

	public void setPlaylist_name(String playlist_name) {
		this.playlist_name = playlist_name;
	}

	public String getPlaylist_song_ids() {
		return playlist_song_ids;
	}

	public void setPlaylist_song_ids(String playlist_song_ids) {
		this.playlist_song_ids = playlist_song_ids;
	}

}
