package jp.co.sss;

import static jp.co.sss.util.WebDriverUtils.*;
import static org.junit.jupiter.api.Assertions.*;
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

@DisplayName("確認演習7 問題1")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin07Test1 {

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
	@DisplayName("1. ビュー1")
	void test01() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		var f = wd.findElement(By.id("f2"));
		assertEquals("http://localhost:9999/kakunin/input", f.getAttribute("action"));
		var i = wd.findElement(By.xpath("//form[@id='f2']/input[@type='submit']"));
		assertEquals("新規登録", i.getAttribute("value"));
	}
	
	@Test
	@Order(2)
    @DisplayName("2. コントローラー（メソッド1）")
	void test02() throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var repo = c.getDeclaredField("inqRepo");
		var repoAnons = Arrays.toString(repo.getAnnotations());
		assertTrue(repoAnons.contains("@org.springframework.beans.factory.annotation.Autowired"), "inqRepoのアノテーションが不適切です");
		var m = c.getDeclaredMethod("input");
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "inputメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/input\"}"), "inputメソッドのURLパスが不適切です");

    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/input");
		mock.perform(req)
			.andExpect(view().name("pages/input"))
			.andExpect(status().isOk())
		    .andReturn();
    }

	@Test
	@Order(3)
	@DisplayName("3. ビュー2")
	void test03() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		wd.findElement(By.xpath("//form[@id='f2']/input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ登録", t.getText());
		var f = wd.findElement(By.id("f"));
		assertEquals("http://localhost:9999/kakunin/insert", f.getAttribute("action"));
		assertEquals("post", f.getAttribute("method"));
		var span = wd.findElement(By.id("s"));
		assertEquals("※登録済のNoや未入力だとエラーとなります", span.getText());		
		var detail = wd.findElement(By.id("detail"));
		assertEquals("1", detail.getAttribute("border"));
		var th1 = wd.findElement(By.xpath("//table[@id='detail']//tr[1]/th[1]"));
		assertEquals("No", th1.getText());
		var i1 = wd.findElement(By.xpath("//table[@id='detail']//tr[1]/td[1]/input[@type='number']"));
		assertEquals("id", i1.getAttribute("name"));
		var th2 = wd.findElement(By.xpath("//table[@id='detail']//tr[2]/th[1]"));
		assertEquals("氏名", th2.getText());
		var i2 = wd.findElement(By.xpath("//table[@id='detail']//tr[2]/td[1]/input[@type='text']"));
		assertEquals("name", i2.getAttribute("name"));
		var th3 = wd.findElement(By.xpath("//table[@id='detail']//tr[3]/th[1]"));
		assertEquals("問い合わせ内容", th3.getText());
		var i3 = wd.findElement(By.xpath("//table[@id='detail']//tr[3]/td[1]/input[@type='text']"));
		assertEquals("detail", i3.getAttribute("name"));
		var i4 = wd.findElement(By.xpath("//form[@id='f']//input[@type='submit']"));
		assertEquals("決定", i4.getAttribute("value"));
		var a = wd.findElement(By.xpath("//p[@id='p']/a"));
		assertEquals("http://localhost:9999/kakunin/findAll", a.getAttribute("href"));
		assertEquals("お問い合わせ一覧へ", a.getText());
	}

	@Test
	@Order(4)
	@DisplayName("4. フォームクラス")
	void test04() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var o = InquiryForm.class;
		int id = o.getDeclaredField("id").getModifiers();
		assertTrue(Modifier.isPrivate(id), "idのアクセス修飾子が違います");
		int acGetId = o.getDeclaredMethod("getId").getModifiers();
		assertTrue(Modifier.isPublic(acGetId), "getIdのアクセス修飾子が違います");
		int acSetId = o.getDeclaredMethod("setId", Integer.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetId), "setIdのアクセス修飾子が違います");
		int name = o.getDeclaredField("name").getModifiers();
		assertTrue(Modifier.isPrivate(name), "nameのアクセス修飾子が違います");
		int acGetName = o.getDeclaredMethod("getName").getModifiers();
		assertTrue(Modifier.isPublic(acGetName), "getNameのアクセス修飾子が違います");
		int acSetName = o.getDeclaredMethod("setName", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetName), "setNameのアクセス修飾子が違います");
		int detail = o.getDeclaredField("detail").getModifiers();
		assertTrue(Modifier.isPrivate(detail), "detailのアクセス修飾子が違います");
		int acGetDetail = o.getDeclaredMethod("getDetail").getModifiers();
		assertTrue(Modifier.isPublic(acGetDetail), "getDetailのアクセス修飾子が違います");
		int acSetDetail = o.getDeclaredMethod("setDetail", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetDetail), "setDetailのアクセス修飾子が違います");
		var f = new InquiryForm();
		assertEquals("InquiryForm [id=null, name=null, detail=null]", f.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

    @Test
	@Order(5)
    @DisplayName("5. コントローラー（メソッド2）")
	void tes05(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var m = c.getDeclaredMethod("insert", InquiryForm.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("={\"/insert\"}"), "insertメソッドのURLパスが不適切です");
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.PostMapping")
				|| mAnons.contains("method={POST}"), "insertメソッドのHTTPメソッドが不適切です");

		var f = new InquiryForm();
		f.setId(4);
		f.setName("濱田岳");
		f.setDetail("××ですよね？");

		var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.post("/insert").flashAttr("inquiryForm", f);
		mock.perform(req)
			.andExpect(redirectedUrl("/getReferenceById/4"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("登録:"));
		assertTrue(o.getOut().contains("InquiryForm"));
		assertTrue(o.getOut().contains("4"));
		assertTrue(o.getOut().contains("濱田岳"));
		assertTrue(o.getOut().contains("××ですよね？"));
    }

	@Test
	@Order(6)
	@DisplayName("6. お問い合わせ詳細への遷移（実行時はDBデータの削除が必要）")
	void test06() {
		goTo("http://localhost:9999/kakunin/");
		wd.findElement(By.xpath("//p[@id='p4']/a")).click();
		wd.findElement(By.xpath("//form[@id='f2']/input[@type='submit']")).click();
		wd.findElement(By.xpath("//table[@id='detail']//tr[1]/td[1]/input[@type='number']")).sendKeys("4");
		wd.findElement(By.xpath("//table[@id='detail']//tr[2]/td[1]/input[@type='text']")).sendKeys("濱田岳");
		wd.findElement(By.xpath("//table[@id='detail']//tr[3]/td[1]/input[@type='text']")).sendKeys("××ですよね？");
		wd.findElement(By.xpath("//input[@type='submit']")).click();
		var t = wd.findElement(By.id("t"));
		assertEquals("お問い合わせ詳細", t.getText());
		var td1 = wd.findElement(By.xpath("//table[@id='detail']//tr[1]/td[1]"));
		assertEquals("4", td1.getText());
		var td2 = wd.findElement(By.xpath("//table[@id='detail']//tr[2]/td[1]"));
		assertEquals("濱田岳", td2.getText());
		var td3 = wd.findElement(By.xpath("//table[@id='detail']//tr[3]/td[1]"));
		assertEquals("××ですよね？", td3.getText());
	}

}
