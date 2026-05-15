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
import jp.co.sss.repository.InquiryRepository;

@DisplayName("確認演習5 問題1")
@TestMethodOrder(OrderAnnotation.class)
@ExtendWith(OutputCaptureExtension.class)
@SpringBootTest
class Kakunin05Test1 {

	@Autowired
	InquiryRepository inqRepo;
	
	@BeforeAll
	static void before() {
	}

	@AfterAll
	static void after() {
	}

	@Test
	@Order(4)
	@DisplayName("4. お問い合わせエンティティ")
	void test04() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var c = Inquiry.class;
		var cAnons = Arrays.toString(c.getAnnotations());
		assertTrue(cAnons.contains("@jakarta.persistence.Entity"), "クラスのアノテーションが不適切です");
		assertTrue(cAnons.contains("@jakarta.persistence.Table(name=\"inquiry\""), "@Tableが不適切です");
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
		var detail = c.getDeclaredField("detail");
		var detailAnons = Arrays.toString(detail.getAnnotations());
		assertTrue(detailAnons.contains("@jakarta.persistence.Column"), "detailのアノテーションが不適切です");
		assertTrue(Modifier.isPrivate(detail.getModifiers()), "detailのアクセス修飾子が違います");
		int acGetDetail = c.getDeclaredMethod("getDetail").getModifiers();
		assertTrue(Modifier.isPublic(acGetDetail), "getDetailのアクセス修飾子が違います");
		int acSetDetail = c.getDeclaredMethod("setDetail", String.class).getModifiers();
		assertTrue(Modifier.isPublic(acSetDetail), "setDetailのアクセス修飾子が違います");
		var e = new Inquiry();
		assertEquals("Inquiry [id=null, name=null, detail=null]", e.toString(),
				"toString()メソッドが正しくオーバーライドされていません");
	}

	@Test
	@Order(5)
	@DisplayName("5. お問い合わせリポジトリ")
	void test05() {
		var sup = inqRepo.getClass().getInterfaces()[0].getGenericInterfaces()[0].toString();
		assertTrue(sup.contains("JpaRepository<jp.co.sss.entity.Inquiry, java.lang.Integer>"));
	}

}
