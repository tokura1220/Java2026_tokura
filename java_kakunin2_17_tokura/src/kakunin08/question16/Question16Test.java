package kakunin08.question16;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question16Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question16-1(修飾子)のテスト")
	void test1() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var as = AbstractStudent.class;
		u.assertTrue(Modifier.isAbstract(as.getModifiers()), "AbstractStudentのアクセス修飾子が違います");
		int acOrgName = as.getDeclaredField("ORG_NAME").getModifiers();
		u.assertTrue(Modifier.isProtected(acOrgName) 
				&& Modifier.isStatic(acOrgName) 
				&& Modifier.isFinal(acOrgName), "ORG_NAMEの修飾子が違います");
		int acGrade = as.getDeclaredField("grade").getModifiers();
		u.assertTrue(Modifier.isProtected(acGrade), "gradeのアクセス修飾子が違います");
		int acName = as.getDeclaredField("name").getModifiers();
		u.assertTrue(Modifier.isProtected(acName), "nameのアクセス修飾子が違います");
		int acSelfIntroduction = as.getDeclaredMethod("selfIntroduction").getModifiers();
		u.assertTrue(Modifier.isAbstract(acSelfIntroduction), "selfIntroductionのアクセス修飾子が違います");
	}

	@Test
	@DisplayName("Question16-1(出力)のテスト")
	void test2(){
		u.assertEquals("Java大学1年、田中です。普通の学生です。", r[0]);
		u.assertEquals("Java大学1年、藤田です。コンビニでバイトしてます。", r[1]);
		u.assertEquals("Java大学1年、山本です。バンドでギター担当してます。", r[2]);
	}

	@Test
	@DisplayName("Question16-2のテスト")
	void test3() {
		u.assertEquals("1年経過...", r[3]);
		u.assertEquals("田中は2年に進級しました。", r[4]);
		u.assertEquals("藤田は2年に進級しました。", r[5]);
		u.assertEquals("山本は2年に進級しました。", r[6]);
		u.assertEquals("山本はサークルの部長になりました。", r[7]);
	}

	@Test
	@DisplayName("Question16-3のテスト")
	void test4() {
		u.assertEquals("更に1年経過...", r[8]);
		u.assertEquals("田中は卒業しました。", r[9]);
		u.assertEquals("藤田は卒業しました。", r[10]);
		u.assertEquals("藤田はコンビニ正社員に登用されました。", r[11]);
		u.assertEquals("山本は卒業しました。", r[12]);
	}
	
}
