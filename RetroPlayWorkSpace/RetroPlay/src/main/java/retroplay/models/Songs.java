package retroplay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Songs")
public class Songs {
	
	@Id
	@Column(name = "song_id")
	private String song_id;
	
	@Column(name = "song_name")
	private String song_name;
	
	@Column(name = "artist_ids")
	private String artist_ids;
	
	@Column(name = "song_banner")
	private String song_banner;
	
	@Column(name = "song_date")
	private String song_date;
	
	@Column(name = "song_gif_id")
	private String song_gif_id;
	
	@Column(name = "song_length")
	private String song_length;
	
	@Column(name = "song_link")
	private String song_link;
	
	@Column(name = "song_mood")
	private String song_mood;
	
	@Column(name = "song_language")
	private String song_language;
	
	@Column(name = "song_movie")
	private String song_movie;

	public String getSong_id() {
		return song_id;
	}

	public void setSong_id(String song_id) {
		this.song_id = song_id;
	}

	public String getSong_name() {
		return song_name;
	}

	public void setSong_name(String song_name) {
		this.song_name = song_name;
	}

	public String getArtist_ids() {
		return artist_ids;
	}

	public void setArtist_ids(String artist_ids) {
		this.artist_ids = artist_ids;
	}

	public String getSong_banner() {
		return song_banner;
	}

	public void setSong_banner(String song_banner) {
		this.song_banner = song_banner;
	}

	public String getSong_date() {
		return song_date;
	}

	public void setSong_date(String song_date) {
		this.song_date = song_date;
	}

	public String getSong_gif_id() {
		return song_gif_id;
	}

	public void setSong_gif_id(String song_gif_id) {
		this.song_gif_id = song_gif_id;
	}

	public String getSong_length() {
		return song_length;
	}

	public void setSong_length(String song_length) {
		this.song_length = song_length;
	}

	public String getSong_link() {
		return song_link;
	}

	public void setSong_link(String song_link) {
		this.song_link = song_link;
	}

	public String getSong_mood() {
		return song_mood;
	}

	public void setSong_mood(String song_mood) {
		this.song_mood = song_mood;
	}

	public String getSong_language() {
		return song_language;
	}

	public void setSong_language(String song_language) {
		this.song_language = song_language;
	}

}
