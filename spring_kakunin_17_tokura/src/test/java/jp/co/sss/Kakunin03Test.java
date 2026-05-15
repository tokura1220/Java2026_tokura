package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.lang.reflect.Modifier;
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
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.sss.controller.Kakunin03Controller;
import jp.co.sss.form.GetForm;

@DisplayName("確認演習3")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin03Test {

	@InjectMocks
	Kakunin03Controller ctr;

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
		var a = wd.findElement(By.xpath("//p[@id='p2']/a"));
		assertEquals("GETメソッドでパラメータを送信", a.getText());
		assertEquals("http://localhost:9999/kakunin/get?no=111", a.getAttribute("href"));
	}
	
    @Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void tes02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var m = c.getDeclaredMethod("get", int.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "getメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/get\"}"), "getメソッドのURLパスが不適切です");

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
		mock.perform(get("/get?no=111"))
		    .andExpect(view().name("pages/get"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("get():111"));
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p2']/a")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("入力ページ", t.getText());
		var f = wd.findElement(By.id("f"));
		assertEquals("http://localhost:9999/kakunin/post", f.getAttribute("action"));
		assertEquals("post", f.getAttribute("method"));
		var i1 = wd.findElement(By.xpath("//input[@type='number']"));
		assertEquals("no", i1.getAttribute("name"));
		var i2 = wd.findElement(By.xpath("//input[@type='submit']"));
		assertEquals("POSTメソッドでパラメータを送信", i2.getAttribute("value"));
	}

	@Test
	@Order(4)
	@DisplayName("4. フォームクラス")
	void test04() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var o = GetForm.class;
		int no = o.getDeclaredField("no").getModifiers();
		assertTrue(Modifier.isPrivate(no), "noのアクセス修飾子が違います");
		int acGetNo = o.getDeclaredMethod("getNo").getModifiers();
		assertTrue(Modifier.isPublic(acGetNo), "getNoのアクセス修飾子が違います");
		int acSetNo = o.getDeclaredMethod("setNo", int.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetNo), "setNoのアクセス修飾子が違います");
	}

    @Test
	@Order(5)
    @DisplayName("5. コントローラー（メソッド2）")
	void tes05(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("post", GetForm.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.PostMapping"), "postメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/post\"}"), "postメソッドのURLパスが不適切です");
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.PostMapping")
				|| mAnons.contains("method={POST}"), "postメソッドのHTTPメソッドが不適切です");

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
		var f = new GetForm();
		f.setNo(222);
    	var req = MockMvcRequestBuilders.post("/post").flashAttr("getForm", f);
		mock.perform(req)
			.andExpect(redirectedUrl("/"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("post():222"));
    }

	@Test
	@Order(6)
	@DisplayName("6. ウェルカムページへの遷移")
	void test06() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p2']/a")).click();
		wd.findElement(By.xpath("//input[@type='number']")).sendKeys("222");
		wd.findElement(By.xpath("//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("トップページ", t.getText());
	}

}
