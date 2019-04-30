package com.techelevator;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller 
public class RadishesController {

	@RequestMapping("/radishesProductPage")
	public String displayRadishes() {
		
		return "radishesProductPage";
	}
}
