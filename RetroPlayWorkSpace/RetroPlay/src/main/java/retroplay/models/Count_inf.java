package retroplay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Count_inf")
public class Count_inf {

	@Id
	@Column(name = "songs_count")
	private Integer songs_count;

	public Integer getSongs_count() {
		return songs_count;
	}

	public void setSongs_count(Integer songs_count) {
		this.songs_count = songs_count;
	}

	public Integer getUsers_count() {
		return users_count;
	}

	public void setUsers_count(Integer users_count) {
		this.users_count = users_count;
	}

	public Integer getPlaylist_count() {
		return playlist_count;
	}

	public void setPlaylist_count(Integer playlist_count) {
		this.playlist_count = playlist_count;
	}

	public Integer getArtists_count() {
		return artists_count;
	}

	public void setArtists_count(Integer artists_count) {
		this.artists_count = artists_count;
	}

	@Column(name = "users_count")
	private Integer users_count;

	@Column(name = "playlist_count")
	private Integer playlist_count;

	@Column(name = "artists_count")
	private Integer artists_count;

}
