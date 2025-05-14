package pti.treasurehunter_rest.service;

import org.springframework.stereotype.Service;

import pti.treasurehunter_rest.database.Database;
import pti.treasurehunter_rest.dto.GameDto;
import pti.treasurehunter_rest.model.Game;

@Service
public class AppService {
	
	private Database db;
	
	public AppService(Database db) {
		super();
		this.db = db;
	}

	public void saveGame(GameDto gameDto) {
		
		Game game = new Game();
				game.setId(null);
				game.setUserId(gameDto.getUserId());
				game.setStartGame(gameDto.getStartGame());
				game.setSteps(gameDto.getSteps());
				game.setResult(gameDto.isResult());
				game.setLastSaved(gameDto.getLastSaved());
		
		db.saveGame(game);
		
	}


}