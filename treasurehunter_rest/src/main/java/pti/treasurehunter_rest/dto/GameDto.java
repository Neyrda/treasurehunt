package pti.treasurehunter_rest.dto;

import java.time.OffsetDateTime;

public class GameDto {

	private int userId;
	private OffsetDateTime startGame;
	private int steps;
	private boolean result;
	private OffsetDateTime lastSaved;
	
	public GameDto(int userId, OffsetDateTime startGame, int steps, boolean result, OffsetDateTime lastSaved) {
		super();
		this.userId = userId;
		this.startGame = startGame;
		this.steps = steps;
		this.result = result;
		this.lastSaved = lastSaved;
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

	public int getSteps() {
		return steps;
	}

	public void setSteps(int steps) {
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