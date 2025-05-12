package pti.treasurehunter.dto;

public class UserDto {
	
	private int id;
	private String userName;
	private int lives;
	private Integer record;
	
	public UserDto(int id, String userName, int lives, Integer record) {
		super();
		this.id = id;
		this.userName = userName;
		this.lives = lives;
		this.record = record;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getLives() {
		return lives;
	}

	public void setLives(int lives) {
		this.lives = lives;
	}

	public Integer getRecord() {
		return record;
	}

	public void setRecord(Integer record) {
		this.record = record;
	}
}
