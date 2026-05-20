package jp.co.sss.practice.p04.q02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jakarta.servlet.http.HttpSession; 


@Controller 

public class Practice0402Controller {
	@RequestMapping(path = "/numguess/start",method = RequestMethod.GET) 
	public String numguess(HttpSession session) { 
		
		Integer hitNumber = (int) (Math.floor(Math.random() * 9) + 1);
//		⚫ 生成した数値をセッションスコープに保存 
		session.setAttribute("hitNumber",hitNumber);
//		⚫ 当たりの数値をコンソールに出力(動作確認用) 
		System.out.println(hitNumber);
		
		return "practice04/02/numguess_start" ; 
		
	}
	
	@RequestMapping(path = "/numguess/input",method = RequestMethod.GET) 
	public String inpuNum() { 
		return "practice04/02/numguess_input"; 
		
	}
	
	@RequestMapping(path = "/numguess/judge",method = RequestMethod.GET) 
	public String judgetNum(HttpSession session,Integer inputNum) { 
		int num1 = (Integer)session.getAttribute("hitNumber");
		int num2 = inputNum;
		
		if(num1 == num2) {
			return "redirect:/numguess/hit";
		}else {
			return "practice04/02/numguess_judge";
		}
	}
	
	@RequestMapping(path = "/numguess/hit",method = RequestMethod.GET) 
	public String nitNum(Model model,HttpSession session) { 
		int num1 = (Integer)session.getAttribute("hitNumber");
		
		String msg = "当たりです！ 正解は" + num1 + "でした。";
		model.addAttribute("msg",msg);
		
		return "practice04/02/numguess_end"; 
		
	}
	
	

}
