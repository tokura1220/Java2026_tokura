package jp.co.sss.shop.controller;

//2章 ソースコード 2-1,2-2,2-3,2-4
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
	@RequestMapping(path = "/")
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

	// 3章 ソースコード 3-4
	@RequestMapping("/transition")
	public String sampleTransition() {
		return "sample_transition";
	}

	// 3章 ソースコード 3-4
	@RequestMapping("/index_f")
	public String indexForward() {
		return "index";
	}

	// 3章 ソースコード 3-6
	@RequestMapping("/index_r")
	public String indexRedirect() {
		return "redirect:/";
	}

	// 12章 ソースコード 12-10
	@RequestMapping("/layout_view")
	public String layoutView() {
		return "layout_view";
	}

}
