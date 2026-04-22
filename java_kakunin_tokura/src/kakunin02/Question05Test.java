package kakunin02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question05Test {

	private static TestUtil u = new TestUtil();
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u.append("65.5");
		u.append("可");
		u.append("95");
		u.setIn();
		Question05.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question05-1のテスト")
	void test1() {
		u.assertEquals("得点を入力:", r[0]);
	}

	@Test
	@DisplayName("Question05-2のテスト")
	void test2() {
		u.assertEquals("あなたの成績:可", r[1]);
	}

	@Test
	@DisplayName("Question05-3のテスト")
	void test3() {
		u.assertEquals("成績を入力:", r[2]);
		u.assertEquals("成績判定結果:合格", r[3]);
	}

	@Test
	@DisplayName("Question05-4のテスト")
	void test4() {
		u.assertEquals("出席率を入力:", r[4]);
		u.assertEquals("単位認定結果:認定", r[5]);
	}

}
