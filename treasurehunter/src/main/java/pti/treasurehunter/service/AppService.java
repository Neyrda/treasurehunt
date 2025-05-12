package pti.treasurehunter.service;

import org.springframework.stereotype.Service;

import pti.treasurehunter.database.Database;
import pti.treasurehunter.dto.UserDto;
import pti.treasurehunter.model.User;

@Service
public class AppService {
	
	private Database db;
	
	public AppService(Database db) {
		super();
		this.db = db;
	}


	public UserDto loginUser(String userName, String password) {
		UserDto userDto = null;
		
		User user = db.getUserByNameAndPassword(userName, password);
		
		if(user != null) {
			userDto = new UserDto(
					user.getId(),
					user.getUserName(),
					user.getLives(),
					user.getRecord());
		}
		return userDto;
	}
	
	public UserDto getUserById(int userId) {
		
		UserDto userDto = null;
		
		User user = db.getUserById(userId);
		
		if(user != null) {
			userDto = new UserDto(
					user.getId(),
					user.getUserName(),
					user.getLives(),
					user.getRecord());
		}
		return userDto;
	}
	
	public void updateUser(int userId, int steps) {
		
		User user = db.getUserById(userId);
		
		if(steps < user.getRecord()) {
			user.setRecord(steps);
			db.updateRecord(user);
		}

		
	}


	public void decreaseLives(int userId, int live) {
		
		User user = db.getUserById(userId);
		
		user.setLives(live);
		db.decreaseLives(user);
		
	}

}
