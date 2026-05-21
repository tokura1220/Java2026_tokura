package jp.co.sss.practice.p05.q01.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.sss.practice.p05.entity.FruitsSeason;
import jp.co.sss.practice.p05.repository.FruitsSeasonRepository;

@Controller

public class Practice0501Controller { 
    @Autowired 
    FruitsSeasonRepository fruitsRepo;
    
    @RequestMapping(path="/fruits/list/all",method=RequestMethod.GET)
    public String method1(Model model) {
    	List<FruitsSeason> fruitsList = fruitsRepo.findAll();
    	for (FruitsSeason fruit : fruitsList) {
    		System.out.println(fruit);
    	}
    	model.addAttribute("fruitsList", fruitsList);
    	return "practice05/01/fruits_list";
    }
//    @GetMapping("/fruits/list/all")
//	public String method1(Model model) {
//		List<FruitsSeason> fruitsList = fruitsRepo.findAll();
//		
//		for (FruitsSeason fruit : fruitsList) {
//			System.out.println(fruit);
//		}
//		
//		model.addAttribute("fruitsList", fruitsList);
//		return "practice05/01/fruits_list";
//	}

}
