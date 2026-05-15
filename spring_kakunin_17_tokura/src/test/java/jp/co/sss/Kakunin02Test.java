package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
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
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.sss.controller.Kakunin02Controller;

@DisplayName("確認演習2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin02Test {

	@InjectMocks
	Kakunin02Controller ctr;

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
		var t = wd.findElement(By.id("t"));
		assertEquals("トップページ", t.getText());
		var a = wd.findElement(By.xpath("//p[@id='p1']/a"));
		assertEquals("ページ2へ", a.getText());
		assertEquals("http://localhost:9999/kakunin/forwardPage2", a.getAttribute("href"));
		var src = wd.getPageSource();
		assertTrue(!src.contains("確認演習2"));
	}
	
    @Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void tes02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var m = c.getDeclaredMethod("forwardPage2");
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "forwardPage2メソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/forwardPage2\"}"), "forwardPage2メソッドのURLパスが不適切です");

    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
		mock.perform(get("/forwardPage2"))
			.andExpect(view().name("pages/page2"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("ページ2へフォワード"));
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー")
	void test03() {
		goTo("http://localhost:9999/kakunin/forwardPage2");
		var t = wd.findElement(By.id("t"));
		assertEquals("ページ2", t.getText());
		var a = wd.findElement(By.id("a"));
		assertEquals("トップページへ", a.getText());
		assertEquals("http://localhost:9999/kakunin/redirectTop", a.getAttribute("href"));
	}
	
    @Test
	@Order(4)
    @DisplayName("4. コントローラー（メソッド2）")
	void tes04(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("redirectTop");
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "redirectTopメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/redirectTop\"}"), "redirectTopメソッドのURLパスが不適切です");

    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
		mock.perform(get("/redirectTop"))
			.andExpect(redirectedUrl("/"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("トップページへリダイレクト"));
    }

	@Test
	@Order(5)
	@DisplayName("5. ウェルカムページへの遷移")
	void test05() {
		goTo("http://localhost:9999/kakunin/redirectTop");
		var t = wd.findElement(By.id("t"));
		assertEquals("トップページ", t.getText());
	}

}
