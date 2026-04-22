package kakunin07.question13;

import java.lang.reflect.Modifier;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question13Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question13-1(修飾子)のテスト")
	void test1() throws NoSuchFieldException, SecurityException, NoSuchMethodException {
		var sc = School.class;
		int acStudents = sc.getDeclaredField("students").getModifiers();
		u.assertTrue(Modifier.isStatic(acStudents), "studentsの修飾子が違います");
		int acLastIdx = sc.getDeclaredField("lastIdx").getModifiers();
		u.assertTrue(Modifier.isStatic(acLastIdx), "lastIdxの修飾子が違います");
		int acConst = sc.getDeclaredConstructor().getModifiers();
		u.assertTrue(Modifier.isPrivate(acConst), "コンストラクタの修飾子が違います");
		int acBuild = sc.getDeclaredMethod("build", int.class).getModifiers();
		u.assertTrue(Modifier.isStatic(acBuild), "buildの修飾子が違います");
	}

	@Test
	@DisplayName("Question13-1(出力)のテスト")
	void test2() {
		u.assertEquals("【スクール開講】座席数:5", r[0]);
	}

	@Test
	@DisplayName("Question13-2(修飾子)のテスト")
	void test3() throws NoSuchMethodException, SecurityException {
		var sc = School.class;
		int acSet = sc.getDeclaredMethod("set", Student.class).getModifiers();
		u.assertTrue(Modifier.isStatic(acSet), "setのアクセス修飾子が違います");
	}

	@Test
	@DisplayName("Question13-2(出力)のテスト")
	void test4() {
		u.assertEquals("【入学希望者】番号:10 名前:太郎", r[1]);
		u.assertEquals("【入学希望者】番号:11 名前:花子", r[2]);
		u.assertEquals("【入学希望者】番号:12 名前:春男", r[3]);
		u.assertEquals("【座席案内】席1 名前:太郎", r[4]);
		u.assertEquals("【座席案内】席2 名前:花子", r[5]);
		u.assertEquals("【座席案内】席3 名前:春男", r[6]);
	}

	@Test
	@DisplayName("Question13-3(修飾子)のテスト")
	void test5() throws NoSuchMethodException, SecurityException {
		var sc = School.class;
		int acSeatsLeft = sc.getDeclaredMethod("seatsLeft").getModifiers();
		u.assertTrue(Modifier.isStatic(acSeatsLeft), "seatsLeftのアクセス修飾子が違います");
	}

	@Test
	@DisplayName("Question13-3(出力)のテスト")
	void test6() {
		u.assertEquals("教室の残席数は2です。", r[7]);
	}
	
}
