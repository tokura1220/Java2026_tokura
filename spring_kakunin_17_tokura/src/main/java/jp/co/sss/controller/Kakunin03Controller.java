package jp.co.sss.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.form.GetForm; 


@Controller
public class Kakunin03Controller {
	
	@RequestMapping(path = "/get",method = RequestMethod.GET)
	public String get(int no){
		
		 System.out.println("get():"+ no);
		 
		return "pages/get";
	}
	
	@RequestMapping(path = "/post",method = RequestMethod.POST)
	public String post(GetForm form){
		
		System.out.println("post():" + form.getNo());
		
		return "redirect:/";
	}

}
