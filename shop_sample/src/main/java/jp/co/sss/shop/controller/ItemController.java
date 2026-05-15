package jp.co.sss.shop.controller;

import java.util.Date;

//6章 ソースコード6-4 作成
import org.springframework.beans.BeanUtils; //6章 ソースコード6-10 追加
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable; //6章 ソースコード6-28 追加
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod; //6章 ソースコード6-28 追加

import jp.co.sss.shop.bean.ItemBean; //6章 ソースコード6-10 追加
import jp.co.sss.shop.entity.Item; //6章 ソースコード6-10 追加
import jp.co.sss.shop.form.ItemForm; //6章 ソースコード6-28 追加
import jp.co.sss.shop.repository.ItemRepository; //6章 ソースコード6-10 追加

@Controller
public class ItemController {
	@Autowired
	ItemRepository repository;

	@RequestMapping("/items/findAll")
	public String showItemList(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_list";
	}

	//6章 ソースコード6-8 追加
	@RequestMapping("/items/findAllByOrderByPriceDesc")
	public String showItemListByOrderByPriceDesc(Model model) {
		model.addAttribute("items", repository.findAllByOrderByPriceDesc());
		return "items/item_list";
	}

	//6章 ソースコード6-11 追加
	@RequestMapping("/items/getReferenceById/{id}")
	public String showItem(@PathVariable int id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itemBean = new ItemBean();
		itemBean.setId(item.getId());
		itemBean.setName(item.getName());
		itemBean.setPrice(item.getPrice());
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	//6章 ソースコード6-14 追加
	@RequestMapping("/items/findByPrice/{price}")
	public String showItemListByPrice(@PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByPrice(price));
		return "items/item_list";
	}

	//6章 ソースコード6-18 追加
	@RequestMapping("/items/findByNameAndPrice/{name}/{price}")
	public String showItemListByNameAndPrice(
			@PathVariable String name, @PathVariable Integer price, Model model) {
		model.addAttribute("items", repository.findByNameAndPrice(name, price));
		return "items/item_list";
	}

	//6章 ソースコード6-21 追加
	@RequestMapping("/items/findByNameLike/{name}")
	public String showItemListByNameLike(@PathVariable String name, Model model) {
		model.addAttribute("items", repository.findByNameContaining(name));
		return "items/item_list";
	}

	//6章 ソースコード6-23 追加
	@RequestMapping("/items/findAllAndSetDropdown")
	public String itemListSetDropdown(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/item_list_dropdown";
	}

	//6章 ソースコード6-28 追加
	@RequestMapping("/items/create/input")
	public String createInput() {
		return "items/create_input";
	}

	//6章 ソースコード6-28 追加
	@RequestMapping(path = "/items/create/complete", method = RequestMethod.POST)
	public String createComplete(ItemForm form, Model model) {
		Item item = new Item();
		BeanUtils.copyProperties(form, item, "id");
		item = repository.save(item);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	//6章 ソースコード6-31 追加
	@RequestMapping("/items/update/input/{id}")
	public String updateInput(@PathVariable Integer id, Model model) {
		Item item = repository.getReferenceById(id);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/update_input";
	}

	//6章 ソースコード6-31 追加
	@RequestMapping(path = "/items/update/complete/{id}", method = RequestMethod.POST)
	public String updateComplete(@PathVariable Integer id, ItemForm form, Model model) {
		Item item = repository.getReferenceById(id);
		BeanUtils.copyProperties(form, item, "id");
		item = repository.save(item);
		ItemBean itemBean = new ItemBean();
		BeanUtils.copyProperties(item, itemBean);
		model.addAttribute("item", itemBean);
		return "items/item";
	}

	//6章 ソースコード6-34 追加
	@RequestMapping("/items/delete/input")
	public String deleteInput(Model model) {
		model.addAttribute("items", repository.findAll());
		return "items/delete_input";
	}

	//6章 ソースコード6-34 追加
	@RequestMapping(path = "/items/delete/complete", method = RequestMethod.POST)
	public String deleteComplete(ItemForm form) {
		repository.deleteById(form.getId());
		return "redirect:/items/findAll";
	}
	
	
	//6章(補足) ソースコード6-37 追加
	@RequestMapping("/items/create/input/hidden")
	public String itemInputHidden() {
			
		//入力画面遷移
		return "items/create_input_hidden";

		}

	//6章(補足) ソースコード6-37 追加
	@RequestMapping("/items/create/check/hidden")
	public String itemCheckHidden(ItemForm form,Model model) {
			
		model.addAttribute("item",form);
		//確認画面遷移
		return "items/create_check_hidden"; 
			
		}


	//6章(補足) ソースコード6-37 追加
	@RequestMapping("/items/create/complete/hidden")
	public String itemCompleteHidden(ItemForm form) {
		//完了画面遷移
		return "items/create_complete_hidden";

		}
	
	//12章 ソースコード12-2 追加
	@RequestMapping("/items/findAllJs")
	public String sampleCss(Model model) {
		model.addAttribute("items", repository.findAll());
		model.addAttribute("now", new Date());
		return "items/item_list_js";
	}

}