package retroplay.models;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Users")
public class Users {
	
	@Id
	@Column(name="user_id")
	private String user_id;
	@Column(name="user_name")
	private String user_name;
	@Column(name="email_id")
	private String email_id;
	@Column(name="password")
	private String password;
	@Column(name="gender")
	private String gender;
	@Column(name="pic_id")
	private String pic_id;
	@Column(name="playlist_ids")
	private String playlist_ids;
	@Column(name="dob")
	private Date dob;
	@Column(name="phone_no")
	private String phone_no;
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getEmail_id() {
		return email_id;
	}
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPic_id() {
		return pic_id;
	}
	public void setPic_id(String pic_id) {
		this.pic_id = pic_id;
	}
	public String getPlaylist_ids() {
		return playlist_ids;
	}
	public void setPlaylist_ids(String playlist_ids) {
		this.playlist_ids = playlist_ids;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getPhone_no() {
		return phone_no;
	}
	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

}
