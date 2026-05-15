package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
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
import org.springframework.ui.Model;

import jp.co.sss.controller.Kakunin06Controller;
import jp.co.sss.entity.Inquiry;
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習6 問題1")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin06Test1 {

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
	@DisplayName("1. ビュー1")
	void test01() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		var a = wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[1]/a"));
		assertEquals("http://localhost:9999/kakunin/getReferenceById/1", a.getAttribute("href"));
		assertEquals("1", a.getText());
	}
	
	@Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void test02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var repo = c.getDeclaredField("inqRepo");
		var repoAnons = Arrays.toString(repo.getAnnotations());
		assertTrue(repoAnons.contains("@org.springframework.beans.factory.annotation.Autowired"), "inqRepoのアノテーションが不適切です");
		var m = c.getDeclaredMethod("getReferenceById", Integer.class, Model.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "getReferenceByIdメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/getReferenceById/{id}\"}"), "getReferenceByIdメソッドのURLパスが不適切です");

		var inc = new Inquiry();
		inc.setId(1);
		inc.setName("佐藤二郎");
		inc.setDetail("○×○でしょうか。");

		when(inqRepo.getReferenceById(1)).thenReturn(inc);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/getReferenceById/1");
		mock.perform(req)
			.andExpect(model().attribute("inquiry", inc))
			.andExpect(view().name("pages/detail"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("詳細:"));
		assertTrue(o.getOut().contains("Inquiry"));
		assertTrue(o.getOut().contains("1"));
		assertTrue(o.getOut().contains("佐藤二郎"));
		assertTrue(o.getOut().contains("○×○でしょうか。"));
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー2")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[1]/a")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ詳細", t.getText());
		var detail = wd.findElement(By.id("detail"));
		assertEquals("1", detail.getAttribute("border"));
		var th1 = wd.findElement(By.xpath("//table[@id='detail']//tr[1]/th[1]"));
		assertEquals("No", th1.getText());
		var td1 = wd.findElement(By.xpath("//table[@id='detail']//tr[1]/td[1]"));
		assertEquals("1", td1.getText());
		var th2 = wd.findElement(By.xpath("//table[@id='detail']//tr[2]/th[1]"));
		assertEquals("氏名", th2.getText());
		var td2 = wd.findElement(By.xpath("//table[@id='detail']//tr[2]/td[1]"));
		assertEquals("佐藤二郎", td2.getText());
		var th3 = wd.findElement(By.xpath("//table[@id='detail']//tr[3]/th[1]"));
		assertEquals("問い合わせ内容", th3.getText());
		var td3 = wd.findElement(By.xpath("//table[@id='detail']//tr[3]/td[1]"));
		assertEquals("○×○でしょうか。", td3.getText());
		var a = wd.findElement(By.xpath("//p[@id='p']/a"));
		assertEquals("http://localhost:9999/kakunin/findAll", a.getAttribute("href"));
		assertEquals("お問い合わせ一覧へ", a.getText());
	}

}
