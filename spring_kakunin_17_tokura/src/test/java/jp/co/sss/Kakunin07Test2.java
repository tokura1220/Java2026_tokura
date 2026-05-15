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

import jp.co.sss.controller.Kakunin07Controller;
import jp.co.sss.form.InquiryForm;
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習7 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin07Test2 {

	@Mock
	InquiryRepository inqRepo;
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
	@DisplayName("1. ビュー3")
	void test01() {
		goTo("http://localhost:9999/kakunin/getReferenceById/4");
		var f = wd.findElement(By.id("f"));
		assertEquals("http://localhost:9999/kakunin/delete", f.getAttribute("action"));
		var i1 = wd.findElement(By.xpath("//form[@id='f']/input[@type='hidden']"));
		assertEquals("id", i1.getAttribute("name"));
		assertEquals("4", i1.getAttribute("value"));
		var i2 = wd.findElement(By.xpath("//form[@id='f']/input[@type='submit']"));
		assertEquals("削除", i2.getAttribute("value"));
	}
	
	@Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド3）")
	void test02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("delete", InquiryForm.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("={\"/delete\"}"), "deleteメソッドのURLパスが不適切です");
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.PostMapping")
				|| mAnons.contains("method={POST}"), "deleteメソッドのHTTPメソッドが不適切です");

		var f = new InquiryForm();
		f.setId(4);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/delete").flashAttr("inquiryForm", f);
		mock.perform(req)
			.andExpect(redirectedUrl("/findAll"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("削除:"));
		assertTrue(o.getOut().contains("InquiryForm"));
		assertTrue(o.getOut().contains("4"));
		assertTrue(!o.getOut().contains("濱田岳"));
		assertTrue(!o.getOut().contains("××ですよね？"));
    }

	@Test
	@Order(3)
	@DisplayName("3. お問い合わせ一覧への遷移（実行前にDBデータの登録が必要）")
	void test06() {
		goTo("http://localhost:9999/kakunin/getReferenceById/4");
		wd.findElement(By.xpath("//form[@id='f']/input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ一覧", t.getText());
		var b = wd.findElement(By.xpath("//body"));
		assertTrue(!b.getText().contains("濱田岳"));
	}

}
