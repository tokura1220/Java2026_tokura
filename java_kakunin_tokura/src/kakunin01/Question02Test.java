package kakunin01;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question02Test {

	private static TestUtil u = new TestUtil();
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u.append("10");
		u.append("太郎");
		u.append("65.5");
		u.setIn();
		Question02.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question02-1のテスト")
	void test1() {
		u.assertEquals("番号を入力:", r[0]);
	}

	@Test
	@DisplayName("Question02-2のテスト")
	void test2() {
		u.assertEquals("名前を入力:", r[1]);
	}

	@Test
	@DisplayName("Question02-3のテスト")
	void test3() {
		u.assertEquals("得点を入力:", r[2]);
	}

	@Test
	@DisplayName("Question02-4のテスト")
	void test4() {
		u.assertEquals("番号:10 名前:太郎 得点:65.5", r[3]);
	}

}
