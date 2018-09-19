package retroplay.models;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Artists")
public class Artists {
	
	@Id
	@Column(name="artist_id")
	private String artist_id;
	
	@Column(name="artist_name")
	private String artist_name;
	
	@Column(name="dob")
	private String dob;
	
	@Column(name="tenure_date")
	private String tenure_date;

	@Column(name="brief_description")
	private String brief_description;

	public String getArtist_id() {
		return artist_id;
	}

	public void setArtist_id(String artist_id) {
		this.artist_id = artist_id;
	}

	public String getArtist_name() {
		return artist_name;
	}

	public void setArtist_name(String artist_name) {
		this.artist_name = artist_name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getTenure_date() {
		return tenure_date;
	}

	public void setTenure_date(String tenure_date) {
		this.tenure_date = tenure_date;
	}

	public String getBrief_description() {
		return brief_description;
	}

	public void setBrief_description(String brief_description) {
		this.brief_description = brief_description;
	}

	public String getPortfolio_pic() {
		return portfolio_pic;
	}

	public void setPortfolio_pic(String portfolio_pic) {
		this.portfolio_pic = portfolio_pic;
	}

	public String getBanner_pic() {
		return banner_pic;
	}

	public void setBanner_pic(String banner_pic) {
		this.banner_pic = banner_pic;
	}

	@Column(name="portfolio_pic")
	private String portfolio_pic;
	
	@Column(name="banner_pic")
	private String banner_pic;
}
