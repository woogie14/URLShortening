package com.bw.shortening.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {
	//main 페이지
	@RequestMapping(value = "/")
	public String home() throws Exception {
		return "home";
	}
}
