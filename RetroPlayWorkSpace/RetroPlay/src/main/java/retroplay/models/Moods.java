package retroplay.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Moods")
public class Moods {

	@Id
	@Column(name = "mood_name")
	private String mood_name;

	public String getMood_name() {
		return mood_name;
	}

	public void setMood_name(String mood_name) {
		this.mood_name = mood_name;
	}

}
