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
import org.openqa.selenium.By;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import jakarta.servlet.http.HttpSession;
import jp.co.sss.controller.Kakunin04Controller;

@DisplayName("確認演習4")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin04Test {

	@InjectMocks
	Kakunin04Controller ctr;

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
	@DisplayName("1. ウェルカムページ（編集1）")
	void test01() {
		goTo("http://localhost:9999/kakunin/");
		var f = wd.findElement(By.id("f"));
		assertEquals("http://localhost:9999/kakunin/request", f.getAttribute("action"));
		var i1 = wd.findElement(By.xpath("//form[@id='f']/input[@type='text']"));
		assertEquals("str1", i1.getAttribute("name"));
		var i2 = wd.findElement(By.xpath("//form[@id='f']/input[@type='submit']"));
		assertEquals("文字列を送信", i2.getAttribute("value"));
	}
	
    @Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void tes02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var m = c.getDeclaredMethod("request", String.class, Model.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "requestメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/request\"}"), "requestメソッドのURLパスが不適切です");

    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/request").param("str1", "AAA");
		mock.perform(req)
			.andExpect(model().attribute("data1", "AAA")) 
			.andExpect(view().name("pages/request"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("文字列1:AAA"));
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//form[@id='f']/input[@type='text']")).sendKeys("AAA");
		wd.findElement(By.xpath("//form[@id='f']/input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("リクエストの値を表示", t.getText());
		var p = wd.findElement(By.id("p")).getText();
		assertTrue(p.contains("が入力されました。"));
		var b = wd.findElement(By.xpath("//p[@id='p']/b"));
		assertEquals("AAA", b.getText());
	}

    @Test
	@Order(4)
    @DisplayName("4. コントローラー（メソッド2）")
	void tes04(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("session", String.class, HttpSession.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.PostMapping"), "sessionメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/session\"}"), "sessionメソッドのURLパスが不適切です");
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.PostMapping")
				|| mAnons.contains("method={POST}"), "sessionメソッドのHTTPメソッドが不適切です");

    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/session").param("str2", "BBB");
		mock.perform(req)
			.andExpect(request().sessionAttribute("data2", "BBB")) 
			.andExpect(redirectedUrl("/"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("文字列2:BBB"));
    }

	@Test
	@Order(5)
	@DisplayName("5. ウェルカムページ（編集2）")
	void test05() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//form[@id='f']/input[@type='text']")).sendKeys("AAA");
		wd.findElement(By.xpath("//form[@id='f']/input[@type='submit']")).click();
		wd.findElement(By.xpath("//form[@id='f']/input[@type='text']")).sendKeys("BBB");
		wd.findElement(By.xpath("//form[@id='f']/input[@type='submit']")).click();
		var p = wd.findElement(By.xpath("//p[@id='p3']"));
		assertTrue(p.getText().contains("セッションの値を表示:"));
		var b = wd.findElement(By.xpath("//p[@id='p3']/b"));
		assertEquals("BBB", b.getText());
	}

}
