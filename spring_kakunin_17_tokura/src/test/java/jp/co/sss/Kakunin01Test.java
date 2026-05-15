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
import org.mockito.InjectMocks;
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.sss.controller.Kakunin01Controller;

@DisplayName("確認演習1")
@TestMethodOrder(OrderAnnotation.class)
@SpringBootTest
class Kakunin01Test {

	@InjectMocks
	Kakunin01Controller ctr;

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
		var a = wd.findElement(By.id("a1"));
		assertEquals("次のページへ", a.getText());
		assertEquals("http://localhost:9999/kakunin/next", a.getAttribute("href"));
		var src = wd.getPageSource();
		assertTrue(src.contains("確認演習1"));
	}
	
    @Test
	@Order(2)
    @DisplayName("2. コントローラー")
	void tes02() throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var m = c.getDeclaredMethod("next");
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "nextメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/next\"}"), "nextメソッドのURLパスが不適切です");
		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
		mock.perform(get("/next"))
			.andExpect(view().name("pages/next"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.id("a1")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("次のページ", t.getText());
		var a = wd.findElement(By.id("a"));
		assertEquals("トップページへ", a.getText());
		assertEquals("http://localhost:9999/kakunin", a.getAttribute("href"));
	}

}
