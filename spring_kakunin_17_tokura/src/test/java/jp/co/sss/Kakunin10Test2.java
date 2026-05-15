package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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
import org.springframework.validation.BindingResult;

import jp.co.sss.controller.Kakunin10Controller;
import jp.co.sss.form.LoginForm;
import jp.co.sss.repository.OperatorRepository;

@DisplayName("確認演習10 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin10Test2 {

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
	@DisplayName("1. ウェルカムページ")
	void test01() {
		goTo("http://localhost:9999/kakunin/");
		var a = wd.findElement(By.xpath("//p[@id='p5']/a"));
		assertEquals("http://localhost:9999/kakunin/login", a.getAttribute("href"));
		assertEquals("ログイン画面へ", a.getText());
	}
	
	@Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void tes02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var m = c.getDeclaredMethod("login", LoginForm.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "loginメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/login\"}"), "loginメソッドのURLパスが不適切です");

		var f = new LoginForm();
		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(view().name("pages/login"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー1")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p5']/a")).click();
		var src = wd.getPageSource();
		assertTrue(src.contains(".error") && src.contains("color") 
				&& src.contains("red"), "style要素のCSSが不適切です。");
		var t = wd.findElement(By.id("t"));
		assertEquals("ログイン", t.getText());
		var f = wd.findElement(By.id("f"));
		assertEquals("http://localhost:9999/kakunin/login", f.getAttribute("action"));
		assertEquals("post", f.getAttribute("method"));
		assertTrue(f.getText().contains("メールアドレス:"));
		var i1 = wd.findElement(By.xpath("//form[@id='f']//input[@type='text']"));
		assertEquals("mail", i1.getAttribute("name"));
		assertTrue(f.getText().contains("パスワード:"));
		var i2 = wd.findElement(By.xpath("//form[@id='f']//input[@type='password']"));
		assertEquals("pass", i2.getAttribute("name"));
		var i3 = wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']"));
		assertEquals("ログイン", i3.getAttribute("value"));
		var p1 = wd.findElement(By.xpath("//p[@id='p1']/a"));
		assertEquals("http://localhost:9999/kakunin/", p1.getAttribute("href"));
		assertEquals("トップページへ", p1.getText());
	}
	
    @Test
	@Order(4)
    @DisplayName("4. コントローラー（メソッド2）入力チェックエラーなし")
	void tes04(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("login", LoginForm.class, BindingResult.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("={\"/login\"}"), "loginメソッドのURLパスが不適切です");
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.PostMapping")
				|| mAnons.contains("method={POST}"), "loginメソッドのHTTPメソッドが不適切です");

		var mail = "op1@ex.jp";
		var pass = "abcde";
		var f = new LoginForm();
		f.setMail(mail);
		f.setPass(pass);

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(redirectedUrl("/findAll"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("入力値:"));
		assertTrue(o.getOut().contains("LoginForm"));
		assertTrue(o.getOut().contains(mail));
		assertTrue(o.getOut().contains(pass));
    }

	@Test
	@Order(5)
	@DisplayName("お問い合わせ一覧への遷移（入力チェックエラーなし）")
	void test05() {
		goTo("http://localhost:9999/kakunin/login");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='text']")).sendKeys("op1@ex.jp");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='password']")).sendKeys("abcde");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ一覧", t.getText());
	}

    @Test
	@Order(6)
    @DisplayName("4. コントローラー（メソッド2）メールアドレス未入力")
	void tes06(CapturedOutput o) throws Exception {
		var mail = "";
		var pass = "abcde";
		var f = new LoginForm();
		f.setMail(mail);
		f.setPass(pass);
		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(view().name("pages/login"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(7)
	@DisplayName("ログイン画面への遷移（メールアドレス未入力）")
	void test07() {
		goTo("http://localhost:9999/kakunin/login");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='password']")).sendKeys("abcde");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("ログイン", t.getText());
		var s1 = wd.findElement(By.xpath("//form[@id='f']//span[@id='s1']"));
		assertEquals("error", s1.getAttribute("class"));
		assertEquals("メールアドレスは必須入力です。", s1.getText());
	}

    @Test
	@Order(8)
    @DisplayName("4. コントローラー（メソッド2）メールアドレス形式不良")
	void tes08(CapturedOutput o) throws Exception {
		var mail = "op1#ex.jp";
		var pass = "abcde";
		var f = new LoginForm();
		f.setMail(mail);
		f.setPass(pass);
		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(view().name("pages/login"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(9)
	@DisplayName("ログイン画面への遷移（メールアドレス形式不良）")
	void test9() {
		goTo("http://localhost:9999/kakunin/login");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='text']")).sendKeys("op1#ex.jp");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='password']")).sendKeys("abcde");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("ログイン", t.getText());
		var s1 = wd.findElement(By.xpath("//form[@id='f']//span[@id='s1']"));
		assertEquals("error", s1.getAttribute("class"));
		assertEquals("メールアドレスは正しい形式で入力してください。", s1.getText());
	}

    @Test
	@Order(10)
    @DisplayName("4. コントローラー（メソッド2）パスワード文字数不良")
	void tes10(CapturedOutput o) throws Exception {
		var mail = "op1@ex.jp";
		var pass = "abcdeabcde";
		var f = new LoginForm();
		f.setMail(mail);
		f.setPass(pass);
		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/login").flashAttr("loginForm", f);
		mock.perform(req)
			.andExpect(view().name("pages/login"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(11)
	@DisplayName("ログイン画面への遷移（パスワード文字数不良）")
	void test11() {
		goTo("http://localhost:9999/kakunin/login");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='text']")).sendKeys("op1@ex.jp");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='password']")).sendKeys("abcdeabcde");
		wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("ログイン", t.getText());
		var s2 = wd.findElement(By.xpath("//form[@id='f']//span[@id='s2']"));
		assertEquals("error", s2.getAttribute("class"));
		assertEquals("パスワードは4文字以上8文字以内で入力してください。", s2.getText());
	}

}
