package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import jp.co.sss.controller.Kakunin05Controller;
import jp.co.sss.controller.Kakunin06Controller;
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習11 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin11Test2 {

	@Mock
	InquiryRepository inqRepo;
	@InjectMocks
	Kakunin05Controller ctr1;
	@InjectMocks
	Kakunin06Controller ctr2;

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
    @DisplayName("1. コントローラー1")
	void tes01(CapturedOutput o) throws Exception {
		var mock = MockMvcBuilders.standaloneSetup(ctr1).build();
    	var req = MockMvcRequestBuilders.get("/findAll");
		mock.perform(req)
			.andExpect(view().name("pages/list2"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(2)
    @DisplayName("2. コントローラー2")
	void tes02(CapturedOutput o) throws Exception {
    	var mock = MockMvcBuilders.standaloneSetup(ctr2).build();
    	var req = MockMvcRequestBuilders.get("/findByDetailContaining").param("keyword", "〇");
		mock.perform(req)
			.andExpect(view().name("pages/list2"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー")
	void test03() {
		goTo("http://localhost:9999/kakunin/findAll");
		var head = wd.findElement(By.tagName("header")).getText();
		assertTrue(head.contains("お問い合わせシステム"));
		var article = wd.findElement(By.tagName("article")).getText();
		assertTrue(article.contains("お問い合わせ一覧"));
		var foot = wd.findElement(By.tagName("footer")).getText();
		assertTrue(foot.contains("©TOKYO IT SCHOOL"));
	}

	@Test
	@Order(4)
	@DisplayName("4. サイドバー")
	void test04() {
		goTo("http://localhost:9999/kakunin/findAll");
		var search = wd.findElement(By.xpath("//aside/section[1]//form"));
		assertEquals("http://localhost:9999/kakunin/findByDetailContaining", search.getAttribute("action"));
		var input = wd.findElement(By.xpath("//aside/section[2]//form"));
		assertEquals("http://localhost:9999/kakunin/input", input.getAttribute("action"));
		var back = wd.findElement(By.xpath("//aside/section[3]//p/a")).getText();
		assertTrue(back.contains("トップページへ"));
	}

	@Test
	@Order(5)
	@DisplayName("5. レイアウト")
	void test05() {
		goTo("http://localhost:9999/kakunin/findAll");
		var link = wd.findElement(By.xpath("//head/link"));
		assertEquals("http://localhost:9999/kakunin/css/style.css", link.getAttribute("href"));
	}

}
