package com.survivorpoolcle.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MvcController {
	
		@RequestMapping("/")
		public String displayHomePage() {
			return "homePage";
		}
}
