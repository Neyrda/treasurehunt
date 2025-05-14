package pti.treasurehunter_rest.contoller;



import java.time.OffsetDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import pti.treasurehunter_rest.dto.GameDto;
import pti.treasurehunter_rest.service.AppService;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
public class AppController {
	
	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@PostMapping("/treasurehunt/save")
	public ResponseEntity<String> saveGame(
			@RequestParam("userId") int userId,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			@RequestParam("startGame") OffsetDateTime startGame,
			@RequestParam("steps") Integer steps,
			@RequestParam("result") boolean result,
			@DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
			@RequestParam("lastSaved") OffsetDateTime lastSaved) {
		
		GameDto gameDto = new GameDto(userId, startGame, steps, result, lastSaved);
		
		service.saveGame(gameDto);
		
		
		return ResponseEntity.ok("Autosave successful!");
		
		
	}
	
	

}
