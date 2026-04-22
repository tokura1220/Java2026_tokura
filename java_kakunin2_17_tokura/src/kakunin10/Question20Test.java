package kakunin10;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question20Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u = new TestUtil();
		Question20.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question20-1のテスト")
	void test1() {
		u.assertEquals("{hanako=93.5, haruo=46.0, natsuko=70.2, taro=65.5, aki=88.0}", r[0]);
	}

	@Test
	@DisplayName("Question20-2のテスト")
	void test2() {
		u.assertEquals("akiというidは存在します。", r[1]);
		u.assertEquals("akiさんの得点は88.0点です。", r[2]);
	}

	@Test
	@DisplayName("Question20-3のテスト")
	void test3() {
		u.assertEquals("{hanako=true, haruo=false, natsuko=true, taro=true, aki=true}", r[3]);
	}
	
}
