package jp.co.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping; 

@Controller 

public class Kakunin01Controller {
	
	@RequestMapping(path = "/next")
	
	public String next(){
		return "pages/next";
	}

}
