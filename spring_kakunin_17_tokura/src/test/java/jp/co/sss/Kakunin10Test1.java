package jp.co.sss;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Modifier;
import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import jp.co.sss.form.LoginForm;

@DisplayName("確認演習10 問題1")
@TestMethodOrder(OrderAnnotation.class)
class Kakunin10Test1 {

	@Test
	@Order(1)
	@DisplayName("4. フォームクラス")
	void test02() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var c = LoginForm.class;
		var mail = c.getDeclaredField("mail");
		var mailAnons = Arrays.toString(mail.getAnnotations());
		assertTrue(mailAnons.contains("@jakarta.validation.constraints.NotBlank")
				&& mailAnons.contains("@jakarta.validation.constraints.Email"), "mailのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(mail.getModifiers()), "mailのアクセス修飾子が違います");
		int acGetMail = c.getDeclaredMethod("getMail").getModifiers();
		assertTrue(Modifier.isPublic(acGetMail), "getMailのアクセス修飾子が違います");
		int acSetMail = c.getDeclaredMethod("setMail", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetMail), "setMailのアクセス修飾子が違います");
		var pass = c.getDeclaredField("pass");
		var passAnons = Arrays.toString(pass.getAnnotations());
		assertTrue(passAnons.contains("@jakarta.validation.constraints.Size"), "passのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(pass.getModifiers()), "passのアクセス修飾子が違います");
		int acGetPass = c.getDeclaredMethod("getPass").getModifiers();
		assertTrue(Modifier.isPublic(acGetPass), "getPassのアクセス修飾子が違います");
		int acSetPass = c.getDeclaredMethod("setPass", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetPass), "setPassのアクセス修飾子が違います");
		var e = new LoginForm();
		assertEquals("LoginForm [mail=null, pass=null]", e.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

}
