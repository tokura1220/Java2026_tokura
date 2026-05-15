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

import jp.co.sss.controller.Kakunin05Controller;
import jp.co.sss.entity.Inquiry;
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習9 問題1")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin09Test1 {

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
	@DisplayName("1. お問い合わせリポジトリ")
	void test1() throws NoSuchMethodException, SecurityException {
		var rep = inqRepo.getClass();
		var m = rep.getDeclaredMethod("findAllByOrderById");
		assertEquals("java.util.List<jp.co.sss.entity.Inquiry>", m.getGenericReturnType().getTypeName());
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.data.jpa.repository.Query"), "メソッドのアノテーションが不適切です");
	}

	@Test
	@Order(2)
    @DisplayName("2. コントローラー1")
	void tes02(CapturedOutput o) throws Exception {
		var list = new ArrayList<Inquiry>();
		when(inqRepo.findAllByOrderById()).thenReturn(list);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/findAll");
		mock.perform(req)
			.andExpect(model().attribute("inquiries", list))
			.andExpect(view().name("pages/list"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(3)
	@DisplayName("3. お問い合わせ一覧の並び順（お問い合わせNo.1が先頭であること）")
	void test03() {
		goTo("http://localhost:9999/kakunin/findAll");
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ一覧", t.getText());
		var td1 = wd.findElement(By.xpath("//table[@id='list']//tr[2]/td[1]"));
		assertEquals("1", td1.getText());
	}

}
