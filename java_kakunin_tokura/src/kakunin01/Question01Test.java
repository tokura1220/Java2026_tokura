package kakunin01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question01Test {
	
	private static TestUtil u = new TestUtil();
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		Question01.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question01-1のテスト")
	void test1() {
		u.assertEquals("10太郎", r[0]);
	}

	@Test
	@DisplayName("Question01-2のテスト")
	void test2() {
		u.assertContains("得点:65.5", r[1]);
	}

	@Test
	@DisplayName("Question01-3のテスト")
	void test3() {
		u.assertContains("ランク:B", r[1]);
	}

	@Test
	@DisplayName("Question01-4のテスト")
	void test4() {
		u.assertContains("合格:true", r[1]);
	}
}
