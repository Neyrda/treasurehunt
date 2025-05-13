package pti.treasurehunter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import pti.treasurehunter.dto.StatusDto;
import pti.treasurehunter.dto.UserDto;
import pti.treasurehunter.service.AppService;

@Controller
public class AppController {
	
	private AppService service;

	@Autowired
	public AppController(AppService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/")
	public String login() {
		
		return "login.html";
	}
	
	@PostMapping("/login")
	public String checkLogin(
			Model model,
			@RequestParam("username") String userName,
			@RequestParam("password") String password) {
		
		String targetPage = "";
		
		UserDto user = service.loginUser(userName, password);
		
		if(user == null) {
			StatusDto status = new StatusDto(true);
			model.addAttribute("status", status);
			targetPage ="login.html";
		}
		else {
			model.addAttribute("user", user);
			targetPage = "treasurehunt.html";
		}
		
	return targetPage;
	}
	
	@GetMapping("/treasurehunt/uid/{uid}")
	public String startGame(
			Model model,
			@PathVariable("uid") int userId) {
		
		UserDto user = service.getUserById(userId);
			
		model.addAttribute("user", user);
		
		return "treasurehunt.html";
	}
	
	@GetMapping("/treasurehunt/uid/{uid}/result")
	public String showResult(
			Model model,
			@RequestParam("clickCounter") int steps,
			@RequestParam("result") boolean result,
			@RequestParam("lives") int live,
			@PathVariable("uid") int userId) {
		
		service.updateUser(userId,steps, live, result);
		
		model.addAttribute("steps", steps);
		model.addAttribute("result", result);
		return "result.html";
	}

}
