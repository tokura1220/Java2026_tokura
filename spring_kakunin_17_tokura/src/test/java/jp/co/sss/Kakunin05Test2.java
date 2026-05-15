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

import jp.co.sss.controller.Kakunin05Controller;
import jp.co.sss.entity.Inquiry;
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習5 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin05Test2 {

	@Mock
	InquiryRepository inqRepo;
	@InjectMocks
	Kakunin05Controller ctr;
	
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
		var a = wd.findElement(By.xpath("//p[@id='p4']/a"));
		assertEquals("http://localhost:9999/kakunin/findAll", a.getAttribute("href"));
		assertEquals("お問い合わせ一覧", a.getText());
	}
	
	@Test
	@Order(2)
    @DisplayName("2. コントローラー")
	void tes02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var repo = c.getDeclaredField("inqRepo");
		var repoAnons = Arrays.toString(repo.getAnnotations());
		assertTrue(repoAnons.contains("@org.springframework.beans.factory.annotation.Autowired"), "inqRepoのアノテーションが不適切です");
		var m = c.getDeclaredMethod("findAll", Model.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "findAllメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/findAll\"}"), "findAllメソッドのURLパスが不適切です");

		var inc = new Inquiry();
		inc.setId(1);
		inc.setName("佐藤二郎");
		inc.setDetail("○×○でしょうか。");
		var list = new ArrayList<Inquiry>();
		list.add(inc);
		when(inqRepo.findAll()).thenReturn(list);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/findAll");
		mock.perform(req)
			.andExpect(model().attribute("inquiries", list))
			.andExpect(view().name("pages/list"))
			.andExpect(status().isOk())
		    .andReturn();
		assertTrue(o.getOut().contains("一覧:"));
		assertTrue(o.getOut().contains("Inquiry"));
		assertTrue(o.getOut().contains("1"));
		assertTrue(o.getOut().contains("佐藤二郎"));
		assertTrue(o.getOut().contains("○×○でしょうか。"));
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ一覧", t.getText());
		var list = wd.findElement(By.id("list"));
		assertEquals("1", list.getAttribute("border"));
		var th1 = wd.findElement(By.xpath("//table[@id='list']//tr[1]/th[1]"));
		assertEquals("No", th1.getText());
		var th2 = wd.findElement(By.xpath("//table[@id='list']//tr[1]/th[2]"));
		assertEquals("氏名", th2.getText());
		var th3 = wd.findElement(By.xpath("//table[@id='list']//tr[1]/th[3]"));
		assertEquals("問い合わせ内容", th3.getText());
		var td1 = wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[1]"));
		assertEquals("1", td1.getText());
		var td2 = wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[2]"));
		assertEquals("佐藤二郎", td2.getText());
		var td3 = wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[3]"));
		assertEquals("○×○でしょうか。", td3.getText());
		var a = wd.findElement(By.xpath("//p[@id='p1']/a"));
		assertEquals("http://localhost:9999/kakunin/", a.getAttribute("href"));
		assertEquals("トップページへ", a.getText());
	}

}
