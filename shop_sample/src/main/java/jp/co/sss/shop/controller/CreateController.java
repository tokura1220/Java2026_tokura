package jp.co.sss.shop.controller;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.sss.shop.entity.Category;
import jp.co.sss.shop.entity.ItemWithCategory;
import jp.co.sss.shop.form.ItemWithCategoryForm;
import jp.co.sss.shop.repository.ItemWithCategoryRepository;

//7章(補足) ソースコード7-11 作成
@Controller
public class CreateController {

	@Autowired
	ItemWithCategoryRepository repository;

	//登録入力画面表示
	@RequestMapping("/create/input")
	public String createInput() {

		//登録入力画面遷移
		return "create/create_input";
	}

	//登録処理の後、登録完了画面表示
	@RequestMapping("/create/complete")
	public String createComplete(ItemWithCategoryForm form, Model model) {

		//レコード登録のため、エンティティのオブジェクトを作成
		ItemWithCategory itemWithCategory = new ItemWithCategory();

		//フォームから受け取ったnameとpriceの値のみitemWithCategoryにコピー
		BeanUtils.copyProperties(form, itemWithCategory);

		//categoryフィールドにカテゴリ情報を設定するためのオブジェクトを作成
		Category category = new Category();

		//フォームで受け取ったカテゴリIDを、Categoryオブジェクトのフィールドidに代入
		category.setId(form.getCategoryId());

		//categoryオブジェクトをitemWithCategoryのcategoryフィールドに代入
		itemWithCategory.setCategory(category);

		//save()メソッドを呼び出し、登録したレコード情報をitemWithCategoryに戻す
		itemWithCategory = repository.save(itemWithCategory);

		model.addAttribute("item", itemWithCategory);

		//登録完了画面遷移
		return "create/create_complete";
	}

}
