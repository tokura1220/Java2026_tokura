package jp.co.sss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.entity.Inquiry;
import jp.co.sss.repository.InquiryRepository;

@Controller
public class Kakunin05Controller {
    @Autowired 
    InquiryRepository inqRepo;
    
    @RequestMapping(path="/findAll",method=RequestMethod.GET) 
    public String findAll(Model model) { 
        List <Inquiry>inqList = inqRepo.findAll();
        
        for (Inquiry inq:inqList) {
        	System.out.println("一覧:"+inq);
        }
        model.addAttribute("inquiries",inqRepo .findAll()); 
        return "pages/list"; 
    } 
//    @GetMapping("/fruits/list/all")
//    public String method1(Model model) {
//    	List<FruitsSeason> fruitsList = fruitsRepo.findAll();
//    	for (FruitsSeason fruit : fruitsList) {
//    		System.out.println(fruit);
//    	}
//    	model.addAttribute("fruitsList", fruitsList);
//    	return "practice05/01/fruits_list";
//    }
//    
	
}
