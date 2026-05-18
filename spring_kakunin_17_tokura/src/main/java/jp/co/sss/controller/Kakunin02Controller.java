package jp.co.sss.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 


public class Kakunin02Controller {
	
	@RequestMapping(path = "/forwardPage2") 

	public String forwardPage2(){ 
		
		System.out.println("ページ2へフォワード");
		
		return "pages/page2"; 
		
		
	}
	
//	トップページにリダイレクト
	
	@RequestMapping(path = "/redirectTop") 

	public String redirectTop(){ 
		
		System.out.println("トップページへリダイレクト");
		
		return "redirect:/"; 
		
		
	}

	
}
