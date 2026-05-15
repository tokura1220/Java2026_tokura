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
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import jp.co.sss.controller.Kakunin09Controller;
import jp.co.sss.entity.Operator;
import jp.co.sss.repository.OperatorRepository;

@DisplayName("確認演習9 問題2")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin09Test2 {

	@Mock
	OperatorRepository opRepo;
	@InjectMocks
	Kakunin09Controller ctr;
	
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
	@DisplayName("1. オペレーターリポジトリ")
	void test1() throws NoSuchMethodException, SecurityException {
		var rep = opRepo.getClass();
		var m = rep.getDeclaredMethod("findByMailAndPass", String.class, String.class);
		assertEquals("jp.co.sss.entity.Operator", m.getReturnType().getTypeName());
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.data.jpa.repository.Query"), "メソッドのアノテーションが不適切です");
	}

	@Test
	@Order(2)
    @DisplayName("2. コントローラー2（該当者が存在する場合）")
	void tes02(CapturedOutput o) throws Exception {
		var c = ctr.getClass();
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@org.springframework.stereotype.Controller"), "クラスのアノテーションが不適切です");
		var m = c.getDeclaredMethod("loginTest", String.class, String.class);
		var mAnons = Arrays.toString(m.getAnnotations());
		assertTrue(mAnons.contains("@org.springframework.web.bind.annotation.RequestMapping")
				|| mAnons.contains("@org.springframework.web.bind.annotation.GetMapping"), "loginTestメソッドのアノテーションが不適切です");
		assertTrue(mAnons.contains("={\"/loginTest\"}"), "loginTestメソッドのURLパスが不適切です");

		var op = new Operator();
		op.setId(2);
		op.setName("オペレータ鈴木");
		op.setMail("op1@ex.jp");
		op.setPassword("abcde");
		when(opRepo.findByMailAndPass("op1@ex.jp", "abcde")).thenReturn(op);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/loginTest")
    			.param("mail", "op1@ex.jp").param("pass", "abcde");
		mock.perform(req)
			.andExpect(redirectedUrl("/findAll"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("検索結果:"));
		assertTrue(o.getOut().contains("Operator"));
		assertTrue(o.getOut().contains("2"));
		assertTrue(o.getOut().contains("オペレータ鈴木"));
		assertTrue(o.getOut().contains("op1@ex.jp"));
		assertTrue(o.getOut().contains("abcde"));
	}

	@Test
	@Order(3)
    @DisplayName("3. コントローラー2（該当者が存在しない場合）")
	void tes03(CapturedOutput o) throws Exception {
		when(opRepo.findByMailAndPass("xxx@ex.jp", "xxxxx")).thenReturn(null);
    	var mock = MockMvcBuilders.standaloneSetup(ctr).build();
    	var req = MockMvcRequestBuilders.get("/loginTest")
    			.param("mail", "xxx@ex.jp").param("pass", "xxxxx");
		mock.perform(req)
			.andExpect(redirectedUrl("/findAll"))
			.andExpect(status().is(302))
		    .andReturn();
		assertTrue(o.getOut().contains("検索結果:"));
		assertTrue(o.getOut().contains("null"));
	}

}
