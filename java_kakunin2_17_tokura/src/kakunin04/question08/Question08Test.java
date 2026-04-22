package kakunin04.question08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question08Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question08-1のテスト")
	void test1() {
		u.assertContains("kakunin04.question08.Student@", r[0]);
		u.assertContains("kakunin04.question08.Student@", r[1]);
	}

	@Test
	@DisplayName("Question08-2のテスト")
	void test2() {
		u.assertEquals("名前:太郎", r[2]);
		u.assertEquals("名前:花子", r[3]);
	}

	@Test
	@DisplayName("Question08-3のテスト")
	void test3() {
		u.assertEquals("1人目は太郎", r[4]);
		u.assertEquals("2人目は花子", r[5]);
		u.assertEquals("3人目はまだいません", r[6]);
	}
	
}
