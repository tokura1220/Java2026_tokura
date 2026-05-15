package jp.co.sss;

import static org.junit.jupiter.api.Assertions.*;

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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.system.OutputCaptureExtension;

import jp.co.sss.entity.Inquiry;
import jp.co.sss.entity.Operator;
import jp.co.sss.repository.OperatorRepository;

@DisplayName("確認演習8 問題1")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin08Test1 {

	@Autowired
	OperatorRepository opRepo;
	
	@BeforeAll
	static void before() {
	}

	@AfterAll
	static void after() {
	}

	@Test
	@Order(2)
	@DisplayName("2. オペレーターエンティティ")
	void test02() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var c = Operator.class;
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@jakarta.persistence.Entity"), "クラスのアノテーションが不適切です");
		assertTrue(cAnons.contains("@jakarta.persistence.Table(name=\"operator\""), "@Tableが不適切です");
		var id = c.getDeclaredField("id");
		var idAnons = Arrays.toString(id.getAnnotations());
		assertTrue(idAnons.contains("@jakarta.persistence.Id"), "idのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(id.getModifiers()), "idのアクセス修飾子が違います");
		int acGetId = c.getDeclaredMethod("getId").getModifiers();
		assertTrue(Modifier.isPublic(acGetId), "getIdのアクセス修飾子が違います");
		int acSetId = c.getDeclaredMethod("setId", Integer.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetId), "setIdのアクセス修飾子が違います");
		var name = c.getDeclaredField("name");
		var nameAnons = Arrays.toString(name.getAnnotations());
		assertTrue(nameAnons.contains("@jakarta.persistence.Column"), "nameのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(name.getModifiers()), "nameのアクセス修飾子が違います");
		int acGetName = c.getDeclaredMethod("getName").getModifiers();
		assertTrue(Modifier.isPublic(acGetName), "getNameのアクセス修飾子が違います");
		int acSetName = c.getDeclaredMethod("setName", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetName), "setNameのアクセス修飾子が違います");
		var mail = c.getDeclaredField("mail");
		var mailAnons = Arrays.toString(mail.getAnnotations());
		assertTrue(mailAnons.contains("@jakarta.persistence.Column"), "mailのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(mail.getModifiers()), "mailのアクセス修飾子が違います");
		int acGetMail = c.getDeclaredMethod("getMail").getModifiers();
		assertTrue(Modifier.isPublic(acGetMail), "getMailのアクセス修飾子が違います");
		int acSetMail = c.getDeclaredMethod("setMail", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetMail), "setMailのアクセス修飾子が違います");
		var password = c.getDeclaredField("password");
		var passwordAnons = Arrays.toString(password.getAnnotations());
		assertTrue(passwordAnons.contains("@jakarta.persistence.Column"), "passwordのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(password.getModifiers()), "passwordのアクセス修飾子が違います");
		int acGetPassword = c.getDeclaredMethod("getPassword").getModifiers();
		assertTrue(Modifier.isPublic(acGetPassword), "getPasswordのアクセス修飾子が違います");
		int acSetPassword = c.getDeclaredMethod("setPassword", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetPassword), "setPasswordのアクセス修飾子が違います");
		var e = new Operator();
		assertEquals("Operator [id=null, name=null, mail=null, password=null]", e.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

	@Test
	@Order(3)
	@DisplayName("3. オペレーターリポジトリ")
	void test03() {
		var sup = opRepo.getClass().getInterfaces()[0].getGenericInterfaces()[0].toString();
		assertTrue(sup.contains("JpaRepository<jp.co.sss.entity.Operator, java.lang.Integer>"));
	}

	@Test
	@Order(4)
	@DisplayName("4. お問い合わせエンティティ")
	void test04() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var c = Inquiry.class;
		var operator = c.getDeclaredField("operator");
		var opAnons = Arrays.toString(operator.getAnnotations());
		assertTrue(opAnons.contains("@jakarta.persistence.ManyToOne"), "operatorのアノテーションが不適切です");
		assertTrue(opAnons.contains("@jakarta.persistence.JoinColumn"), "operatorのアノテーションが不適切です");
		assertTrue(opAnons.contains("name=\"op_id\""), "operatorのアノテーションが不適切です");
		assertTrue(opAnons.contains("referencedColumnName=\"id\""), "operatorのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(operator.getModifiers()), "operatorのアクセス修飾子が違います");
		int acGetOperator = c.getDeclaredMethod("getOperator").getModifiers();
		assertTrue(Modifier.isPublic(acGetOperator), "getOperatorのアクセス修飾子が違います");
		int acSetOperator = c.getDeclaredMethod("setOperator", Operator.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetOperator), "setOperatorのアクセス修飾子が違います");
		var e = new Inquiry();
		assertEquals("Inquiry [id=null, name=null, detail=null, operator=null]", e.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

}
