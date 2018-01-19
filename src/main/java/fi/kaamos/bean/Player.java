package fi.kaamos.bean;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Player {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	
	private String username;
	
	private int score;
	
	private int playcount;

	public Player() {
		super();
	}

	public Player(int id, String username, int score, int playcount) {
		super();
		Id = id;
		this.username = username;
		this.score = score;
		this.playcount = playcount;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getPlaycount() {
		return playcount;
	}

	public void setPlaycount(int playcount) {
		this.playcount = playcount;
	}

	@Override
	public String toString() {
		return "Player [Id=" + Id + ", username=" + username + ", score=" + score + ", playcount=" + playcount + "]";
	}
}
