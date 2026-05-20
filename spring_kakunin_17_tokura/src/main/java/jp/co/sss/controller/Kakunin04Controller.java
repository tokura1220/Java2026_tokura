package jp.co.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession; 


@Controller 
public class Kakunin04Controller {
	
	@RequestMapping(path = "/request",method = RequestMethod.GET) 
	public String request(String str1, Model model) { 

		
		System.out.println("文字列1:" + str1);
		model.addAttribute("data1",str1);
		
		return "pages/request"; 
		
	}
	@RequestMapping(path = "/session",method = RequestMethod.POST) 
	public String session(String str2, HttpSession session) { 

		System.out.println("文字列2:" + str2);
		session.setAttribute("data2",str2);
		
		return "redirect:/"; 
		
	}

}
