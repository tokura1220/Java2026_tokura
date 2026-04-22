package kakunin07.question17;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question17Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question17-1のテスト")
	void test1() throws NoSuchFieldException, SecurityException {
		var gs = GeneralStudent.class;
		int acGrade = gs.getDeclaredField("grade").getModifiers();
		u.assertTrue(Modifier.isProtected(acGrade), "gradeのアクセス修飾子が違います");
		int acName = gs.getDeclaredField("name").getModifiers();
		u.assertTrue(Modifier.isProtected(acName), "nameのアクセス修飾子が違います");

		u.assertEquals("GeneralStudent [grade=1, name=田中]", r[0]);
		u.assertEquals("PartTimeWorker [job=コンビニでバイト, grade=1, name=藤田]", r[1]);
		u.assertEquals("BandMember [instrument=ギター, grade=1, name=山本]", r[2]);
	}

	@Test
	@DisplayName("Question17-2のテスト")
	void test2() {
		u.assertEquals("Java大学1年、田中です。普通の学生です。", r[3]);
		u.assertEquals("Java大学1年、藤田です。コンビニでバイトしてます。", r[4]);
		u.assertEquals("Java大学1年、山本です。バンドでギター担当してます。", r[5]);
	}

	@Test
	@DisplayName("Question17-3のテスト")
	void test3() throws NoSuchMethodException, SecurityException {
		var gs = GeneralStudent.class;
		int acStudy = gs.getDeclaredMethod("study").getModifiers();
		u.assertTrue(Modifier.isFinal(acStudy), "studyのアクセス修飾子が違います");
		
		u.assertTrue(r[6].equals("今日、田中は選択科目の日です。") 
				|| r[6].equals("今日、田中はゼミがあります。"), r[6]);
		u.assertTrue(r[7].equals("今晩、藤田は夜勤です。") 
				|| r[7].equals("藤田は今日シフトに入ってません。"), r[7]);
		u.assertTrue(r[8].equals("山本は今晩、スタジオ練習日です。") 
				|| r[8].equals("山本は今晩、ライブに出ます。"), r[8]);
	}
	
}
