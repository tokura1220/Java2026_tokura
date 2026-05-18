package jp.co.sss.shop.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller 

public class IndexController {    
	
	@RequestMapping(path = "/shop") 
	
	public String index() { 
		
		return "index"; 
		
	}
	// 3章 ソースコード 3-1
		@RequestMapping("/before")
		public String before() {
			return "before";
		}

		// 3章 ソースコード 3-1
		@RequestMapping("/after")
		public String after() {
			return "after";
		}
}
