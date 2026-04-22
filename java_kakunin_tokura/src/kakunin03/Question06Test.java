package kakunin03;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question06Test {
	
	private static TestUtil u = new TestUtil();
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		Question06.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question06-1のテスト")
	void test1() {
		u.assertEquals("10 太郎 65.5", r[0]);
		u.assertEquals("11 花子 93.5", r[1]);
		u.assertEquals("12 春男 46.0", r[2]);
		u.assertEquals("13 夏子 70.2", r[3]);
		u.assertEquals("14 あき 88.0", r[4]);
	}

	@Test
	@DisplayName("Question06-2のテスト")
	void test2() {
		u.assertEquals("合計:363.2 平均:72", r[5]);
	}

	@Test
	@DisplayName("Question06-3のテスト")
	void test3() {
		u.assertEquals("夏子の判定結果:合格", r[6]);
	}
	
}
