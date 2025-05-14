package pti.treasurehunter_rest.model;



import java.time.OffsetDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
	
	@Id
	@Column(name="id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "user")
	private int userId;
	
	@Column(name = "startgame")
	private OffsetDateTime startGame;
	
	@Column(name = "steps")
	private Integer steps;
	
	@Column(name = "result")
	private boolean result;
	
	@Column(name = "last_saved")
	private OffsetDateTime lastSaved;
	
	

	public Game(Integer id, int userId, OffsetDateTime startGame, Integer steps, boolean result, OffsetDateTime lastSaved) {
		super();
		this.id = id;
		this.userId = userId;
		this.startGame = startGame;
		this.steps = steps;
		this.result = result;
		this.lastSaved = lastSaved;
	}
	
	

	public Game() {
		super();
	}



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public OffsetDateTime getStartGame() {
		return startGame;
	}

	public void setStartGame(OffsetDateTime startGame) {
		this.startGame = startGame;
	}

	public Integer getSteps() {
		return steps;
	}

	public void setSteps(Integer steps) {
		this.steps = steps;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}

	public OffsetDateTime getLastSaved() {
		return lastSaved;
	}

	public void setLastSaved(OffsetDateTime lastSaved) {
		this.lastSaved = lastSaved;
	}
	
	
	
	

}
