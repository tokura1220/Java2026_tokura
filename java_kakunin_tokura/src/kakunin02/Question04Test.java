package kakunin02;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question04Test {
	
	private static TestUtil u = new TestUtil();
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		Question04.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question04-1のテスト")
	void test1() {
		u.assertEquals("要素1:0 要素2:-5", r[0]);
	}

	@Test
	@DisplayName("Question04-2のテスト")
	void test2() {
		u.assertEquals("①data ② ③null", r[1]);
	}

	@Test
	@DisplayName("Question04-3のテスト")
	void test3() {
		u.assertEquals("配列cの最後の値:true", r[2]);
	}

	@Test
	@DisplayName("Question04-4のテスト")
	void test4() {
		u.assertEquals("クラス1最高点:93.5 クラス2最高点:81.0", r[3]);
	}
	
}
