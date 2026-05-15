package jp.co.sss.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 

public class IndexController {    
	
	@RequestMapping(path = "/shop") 
	
	public String index() { 
		
		return "index"; 
		
	}
}
