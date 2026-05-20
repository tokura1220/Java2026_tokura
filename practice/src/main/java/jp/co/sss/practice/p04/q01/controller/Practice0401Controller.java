package jp.co.sss.practice.p04.q01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p04.q01.form.BmiForm;


@Controller 

public class Practice0401Controller {
	@RequestMapping(path = "/bmi/input",method = RequestMethod.GET) 
	public String bmi() { 
		return "practice04/01/bmi_input"; 
		
	}
	
	@RequestMapping(path = "/bmi/result",method = RequestMethod.POST) 
	public String bmiform(BmiForm bmiForm,Model model) { 
		
		Double m =  bmiForm.getHeight()/100;
		m = m * m;
		Double bmi = bmiForm.getWeight() / m;
		bmiForm.setBmi(bmi);
		
		model.addAttribute("form",bmiForm);
		
		return "practice04/01/bmi_result"; 
		
	}
}
