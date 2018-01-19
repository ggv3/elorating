package fi.kaamos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import fi.kaamos.bean.Player;
import fi.kaamos.bean.PlayerRepository;

@RestController
public class EloratingController {
	
	@Autowired
	private PlayerRepository playerReposiroty;

	@RequestMapping("/help")
	public @ResponseBody String help() {
		String help = "foo";
		return help;
	}
	
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public @ResponseBody String addNew(@RequestParam String username) {
		Player player = new Player();
		player.setUsername(username);
		player.setScore(0);
		player.setPlaycount(0);
		playerReposiroty.save(player);
		return "Player " + player.getUsername() + " added!";
	}
}
