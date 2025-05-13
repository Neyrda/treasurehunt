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
	
	public void updateUser(int userId, int steps, int live, boolean result) {
		
		User user = db.getUserById(userId);
		
		if((result == true) && (user.getRecord() == 0 || steps < user.getRecord())) {
			user.setRecord(steps);
			db.updateUser(user);
		}
		
		if(result == false) {
			user.setLives(live);
			db.updateUser(user);
		}

		
	}


}
