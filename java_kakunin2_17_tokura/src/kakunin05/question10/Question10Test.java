package kakunin05.question10;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question10Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question10-1(アクセス権限)のテスト")
	void test1() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var st = Student.class;
		u.assertTrue(Modifier.isPublic(st.getModifiers()), "Studentのアクセス修飾子が違います");
		int acNum = st.getDeclaredField("num").getModifiers();
		u.assertTrue(Modifier.isPrivate(acNum), "numのアクセス修飾子が違います");
		int acName = st.getDeclaredField("name").getModifiers();
		u.assertTrue(Modifier.isPrivate(acName), "nameのアクセス修飾子が違います");
		int acGetNum = st.getDeclaredMethod("getNum").getModifiers();
		u.assertTrue(Modifier.isPublic(acGetNum), "getNumのアクセス修飾子が違います");
		int acSetNum = st.getDeclaredMethod("setNum", int.class).getModifiers();
		u.assertTrue(Modifier.isPublic(acSetNum), "setNumのアクセス修飾子が違います");
		int acGetName = st.getDeclaredMethod("getName").getModifiers();
		u.assertTrue(Modifier.isPublic(acGetName), "getNameのアクセス修飾子が違います");
		int acSetName = st.getDeclaredMethod("setName", String.class).getModifiers();
		u.assertTrue(Modifier.isPublic(acSetName), "setNameのアクセス修飾子が違います");
		var sc = School.class;
		u.assertTrue(Modifier.isPublic(sc.getModifiers()), "Schoolのアクセス修飾子が違います");
		int acStudents = sc.getDeclaredField("students").getModifiers();
		u.assertTrue(Modifier.isPrivate(acStudents), "studentsのアクセス修飾子が違います");
		int acLastIdx = sc.getDeclaredField("lastIdx").getModifiers();
		u.assertTrue(Modifier.isPrivate(acLastIdx), "lastIdxのアクセス修飾子が違います");
		int acSetStudent = sc.getDeclaredMethod("setStudent", int.class, String.class).getModifiers();
		u.assertTrue(Modifier.isPublic(acSetStudent), "setStudentのアクセス修飾子が違います");
	}
	
	@Test
	@DisplayName("Question10-1(出力)のテスト")
	void test2() {
		u.assertEquals("席1に登録しました。", r[0]);
		u.assertEquals("席1 番号:10 名前:太郎", r[1]);
		u.assertEquals("席2に登録しました。", r[2]);
		u.assertEquals("席2 番号:11 名前:花子", r[3]);
		u.assertEquals("席3に登録しました。", r[4]);
		u.assertEquals("席3 番号:12 名前:春男", r[5]);
	}

	@Test
	@DisplayName("Question10-2(アクセス権限)のテスト")
	void test3() throws NoSuchMethodException {
		var sc = School.class;
		int acListStudents = sc.getDeclaredMethod("listStudents").getModifiers();
		u.assertTrue(Modifier.isPublic(acListStudents), "listStudentsのアクセス修飾子が違います");
	}

	@Test
	@DisplayName("Question10-2(出力)のテスト")
	void test4() {
		u.assertEquals("---席順リスト---", r[6]);
		u.assertEquals("席1 番号:10 名前:太郎", r[7]);
		u.assertEquals("席2 番号:11 名前:花子", r[8]);
		u.assertEquals("席3 番号:12 名前:春男", r[9]);
	}
	
}
