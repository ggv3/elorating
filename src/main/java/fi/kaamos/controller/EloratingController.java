package fi.kaamos.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EloratingController {

	@RequestMapping("/help")
	public @ResponseBody String help() {
		String help = "foo";
		return help;
	}
}
