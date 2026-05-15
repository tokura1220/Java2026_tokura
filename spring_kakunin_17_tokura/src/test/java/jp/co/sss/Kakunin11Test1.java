package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.lang.reflect.Modifier;

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

import jp.co.sss.controller.Kakunin10Controller;
import jp.co.sss.entity.Operator;
import jp.co.sss.form.LoginForm;
import jp.co.sss.repository.OperatorRepository;

@DisplayName("確認演習11 問題1")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin11Test1 {

	@Mock
	OperatorRepository opRepo;
	@InjectMocks
	Kakunin10Controller ctr;

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
	@DisplayName("1. フォームクラス")
	void test01() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var c = LoginForm.class;
		var err = c.getDeclaredField("err");
		assertTrue(Modifier.isPrivate(err.getModifiers()), "errのアクセス修飾子が違います");
		int acGetErr = c.getDeclaredMethod("getErr").getModifiers();
		assertTrue(Modifier.isPublic(acGetErr), "getErrのアクセス修飾子が違います");
		int acSetErr = c.getDeclaredMethod("setErr", Boolean.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetErr), "setErrのアクセス修飾子が違います");
		var e = new LoginForm();
		assertEquals("LoginForm [mail=null, pass=null, err=null]", e.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

	@Test
	@Order(2)
    @DisplayName("2. コントローラー（該当者が存在する場合）")
	void tes02(CapturedOutput o) throws Exception {
		var mail = "op1@ex.jp";
		var pass = "abcde";
		var f = new LoginForm();
		f.setMail(mail);
		f.setPass(pass);
		var id = 2;
		var name = "オペレータ鈴木";
		var op = new Operator();
		op.setId(id);
		op.setName(name);
		when(opRepo.findByMailAndPass(mail, pass)).thenReturn(op);

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(redirectedUrl("/findAll"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("検索結果:"));
		assertTrue(o.getOut().contains("Operator"));
		assertTrue(o.getOut().contains("" + id));
		assertTrue(o.getOut().contains(name));
    }

	@Test
	@Order(3)
	@DisplayName("お問い合わせ一覧への遷移（該当者が存在する場合）")
	void test03() {
		goTo("http://localhost:9999/kakunin/login");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='text']")).sendKeys("op1@ex.jp");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='password']")).sendKeys("abcde");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ一覧", t.getText());
	}

	@Test
	@Order(4)
    @DisplayName("2. コントローラー（該当者が存在しない場合）")
	void tes04(CapturedOutput o) throws Exception {
		var mail = "xxx@ex.jp";
		var pass = "xxxxx";
		var f = new LoginForm();
		f.setMail(mail);
		f.setPass(pass);
		when(opRepo.findByMailAndPass(mail, pass)).thenReturn(null);

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(view().name("pages/login"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(5)
	@DisplayName("ログイン画面への遷移（該当者が存在しない場合）")
	void test05() {
		goTo("http://localhost:9999/kakunin/login");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='text']")).sendKeys("xxx@ex.jp");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='password']")).sendKeys("xxxxx");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("ログイン", t.getText());
		var p2 = wd.findElement(By.xpath("//p[@id='p2']"));
		assertEquals("error", p2.getAttribute("class"));
		assertEquals("ログインに失敗しました。", p2.getText());
	}

}
