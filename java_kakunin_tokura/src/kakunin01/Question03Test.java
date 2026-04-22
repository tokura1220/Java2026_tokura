package kakunin01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question03Test {
	
	private static TestUtil u = new TestUtil();
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		Question03.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question03-1のテスト")
	void test1() {
		u.assertEquals("aとbの商は4", r[0]);
	}

	@Test
	@DisplayName("Question03-2のテスト")
	void test2() {
		u.assertEquals("aとbの剰余は1", r[1]);
	}

	@Test
	@DisplayName("Question03-3のテスト")
	void test3() {
		u.assertEquals("(a-1)と(b+1)の積は24", r[2]);
	}

	@Test
	@DisplayName("Question03-4のテスト")
	void test4() {
		u.assertEquals("bに2を足した値をaから引くと1", r[3]);
	}

	@Test
	@DisplayName("Question03-5のテスト")
	void test5() {
		u.assertEquals("eとfの積は4.5", r[4]);
	}

	@Test
	@DisplayName("Question03-6のテスト")
	void test6() {
		u.assertEquals("eとfの商は2", r[5]);
	}

}
