package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

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

import jp.co.sss.controller.Kakunin06Controller;
import jp.co.sss.entity.Inquiry;
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習6 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin06Test2 {

	@Mock
	InquiryRepository inqRepo;
	@InjectMocks
	Kakunin06Controller ctr;
	
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
	@DisplayName("1. リポジトリ")
	void test1() throws NoSuchMethodException, SecurityException {
		var rep = inqRepo.getClass();
		var m = rep.getDeclaredMethod("findByDetailContaining", String.class);
		assertEquals("java.util.List<jp.co.sss.entity.Inquiry>", m.getGenericReturnType().getTypeName());
	}

	@Test
	@Order(2)
	@DisplayName("2. ビュー1")
	void test02() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		var f = wd.findElement(By.id("f1"));
		assertEquals("http://localhost:9999/kakunin/findByDetailContaining", f.getAttribute("action"));
		var i1 = wd.findElement(By.xpath("//form[@id='f1']/input[@type='text']"));
		assertEquals("keyword", i1.getAttribute("name"));
		var i2 = wd.findElement(By.xpath("//form[@id='f1']/input[@type='submit']"));
		assertEquals("あいまい検索", i2.getAttribute("value"));
	}
	
	@Test
	@Order(3)
    @DisplayName("3. コントローラー（メソッド2）")
	void test03(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("findByDetailContaining", String.class, Model.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "findByDetailContainingメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/findByDetailContaining\"}"), "findByDetailContainingメソッドのURLパスが不適切です");

		var k = "佐";
		var inc = new Inquiry();
		inc.setName("佐藤二郎");
		var list = new ArrayList<Inquiry>();
		list.add(inc);
		when(inqRepo.findByDetailContaining(k)).thenReturn(list);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/findByDetailContaining").param("keyword", k);
		mock.perform(req)
			.andExpect(model().attribute("inquiries", list))
			.andExpect(view().name("pages/list"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("検索結果:1件"));
    }

	@Test
	@Order(4)
	@DisplayName("4. ビュー1（検索結果）")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		wd.findElement(By.xpath("//form[@id='f1']/input[@type='text']")).sendKeys("○");
		wd.findElement(By.xpath("//form[@id='f1']/input[@type='submit']")).click();
		var tr2 = wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[3]"));
		assertEquals("○×○でしょうか。", tr2.getText());
		var tr3 = wd.findElement(By.xpath("//table[@id='list']//tr[3]/td[3]"));
		assertEquals("△○△について教えてください。", tr3.getText());
	}

}
