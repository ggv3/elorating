package fi.kaamos.controller;

import java.text.DecimalFormat;

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
		player.setScore(1000);
		player.setPlaycount(0);
		playerReposiroty.save(player);
		return "Player " + player.getUsername() + " added!";
	}
	
	@RequestMapping(value = "/game")
	public @ResponseBody double game(@RequestParam String winner, String loser) {
		
		
		Player wPlayer = playerReposiroty.findByUsername(winner);
		Player lPlayer = playerReposiroty.findByUsername(loser);
		
		wPlayer.setPlaycount(wPlayer.getPlaycount() + 1);
		lPlayer.setPlaycount(lPlayer.getPlaycount() + 1);
		
		DecimalFormat format = new DecimalFormat("0.00");
		double winnerExpectedPercentage = (1 / (Math.pow(10, (lPlayer.getScore()- wPlayer.getScore())/400) + 1));
		winnerExpectedPercentage = Double.valueOf(format.format(winnerExpectedPercentage));
		double loserExpectedPercentage = (1 / (Math.pow(10, (wPlayer.getScore()- lPlayer.getScore())/400) + 1));
		loserExpectedPercentage = Double.valueOf(format.format(loserExpectedPercentage));
		
		int kFactor = 15;
		
		double winnerPoints = Double.valueOf(format.format(kFactor * (1 - winnerExpectedPercentage)));
		
		double loserPoints = Double.valueOf(format.format(kFactor * (0 - loserExpectedPercentage)));
		
		String newLine = System.getProperty("line.separator");
		String result = "Winner expected %" + newLine + winnerExpectedPercentage + newLine + "Loser expected %" + newLine + loserExpectedPercentage + newLine;
		return loserPoints;
	}
}
