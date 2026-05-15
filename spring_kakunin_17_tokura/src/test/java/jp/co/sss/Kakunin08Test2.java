package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import jp.co.sss.controller.Kakunin07Controller;
import jp.co.sss.entity.Operator;
import jp.co.sss.form.InquiryForm;
import jp.co.sss.repository.OperatorRepository;

@DisplayName("確認演習8 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin08Test2 {

	@Mock
	OperatorRepository opRepo;
	@InjectMocks
	Kakunin07Controller ctr;
	
	@BeforeAll
	static void before() {
		createDriver();
	}

	@AfterAll
	static void after() {
		closeDriver();
	}

	@Test
	@Order(1)
	@DisplayName("1. ビュー1")
	void test01() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		var th4 = wd.findElement(By.xpath("//table[@id='list']//tr[1]/th[4]"));
		assertEquals("担当者", th4.getText());
		var b = wd.findElement(By.xpath("//body"));
		assertTrue(b.getText().contains("オペレータ鈴木"));
	}
	
	@Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void test02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var repo = c.getDeclaredField("opRepo");
		var repoAnons = Arrays.toString(repo.getAnnotations());
		assertTrue(repoAnons.contains("@org.springframework.beans.factory.annotation.Autowired"), "opRepoのアノテーションが不適切です");
		var m = c.getDeclaredMethod("input", Model.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "inputメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/input\"}"), "inputメソッドのURLパスが不適切です");

		var op = new Operator();
		op.setId(1);
		op.setName("田中マネージャ");
		var list = new ArrayList<Operator>();
		list.add(op);
		when(opRepo.findAll()).thenReturn(list);

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/input");
		mock.perform(req)
			.andExpect(model().attribute("operators", list))
			.andExpect(view().name("pages/input"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("オペレータ:"));
		assertTrue(o.getOut().contains("Operator"));
		assertTrue(o.getOut().contains("1"));
		assertTrue(o.getOut().contains("田中マネージャ"));
	}

	@Test
	@Order(3)
	@DisplayName("3. ビュー2")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		wd.findElement(By.xpath("//form[@id='f2']/input[@type='submit']")).click();
		var th4 = wd.findElement(By.xpath("//table[@id='detail']//tr[4]/th[1]"));
		assertEquals("担当者No", th4.getText());
		var s = wd.findElement(By.xpath("//table[@id='detail']//tr[4]/td[1]/select"));
		assertEquals("operator.id", s.getAttribute("name"));
		var o = wd.findElement(By.xpath("//table[@id='detail']//tr[4]/td[1]/select/option[1]"));
		assertEquals("1", o.getAttribute("value"));
		assertEquals("田中マネージャ", o.getText());
	}

	@Test
	@Order(4)
	@DisplayName("4. フォームクラス")
	void test04() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var o = InquiryForm.class;
		int operator = o.getDeclaredField("operator").getModifiers();
		assertTrue(Modifier.isPrivate(operator), "operatorのアクセス修飾子が違います");
		int acGetOperator = o.getDeclaredMethod("getOperator").getModifiers();
		assertTrue(Modifier.isPublic(acGetOperator), "getOperatorのアクセス修飾子が違います");
		int acSetOperator = o.getDeclaredMethod("setOperator", Operator.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetOperator), "setOperatorのアクセス修飾子が違います");
		var f = new InquiryForm();
		assertEquals("InquiryForm [id=null, name=null, detail=null, operator=null]", f.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

	@Test
	@Order(5)
	@DisplayName("5. お問い合わせ詳細への遷移（実行時はDBデータの削除が必要）")
	void test06() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		wd.findElement(By.xpath("//form[@id='f2']/input[@type='submit']")).click();
		wd.findElement(By.xpath("//table[@id='detail']//tr[1]/td[1]/input[@type='number']")).sendKeys("6");
		wd.findElement(By.xpath("//table[@id='detail']//tr[2]/td[1]/input[@type='text']")).sendKeys("菅田将暉");
		wd.findElement(By.xpath("//table[@id='detail']//tr[3]/td[1]/input[@type='text']")).sendKeys("あなたの意見ですよね？");
		wd.findElement(By.xpath("//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ詳細", t.getText());
		var td1 = wd.findElement(By.xpath("//table[@id='detail']//tr[1]/td[1]"));
		assertEquals("6", td1.getText());
		var td2 = wd.findElement(By.xpath("//table[@id='detail']//tr[2]/td[1]"));
		assertEquals("菅田将暉", td2.getText());
		var td3 = wd.findElement(By.xpath("//table[@id='detail']//tr[3]/td[1]"));
		assertEquals("あなたの意見ですよね？", td3.getText());
	}

}
