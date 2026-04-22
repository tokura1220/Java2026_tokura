package kakunin08;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question19Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u = new TestUtil();
		u.append("taro");
		u.append("hanako");
		u.append("haruo");
		u.append("natsuko");
		u.append("aki");
		u.setIn();
		Question19.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question19-1のテスト")
	void test1() {
		u.assertEquals("5人分のidを入力:", r[0]);
		u.assertEquals("[taro, hanako, haruo, natsuko, aki]", r[1]);
		u.assertEquals("[65.5, 93.5, 46.0, 70.2, 88.0]", r[2]);
	}

	@Test
	@DisplayName("Question19-2のテスト")
	void test2() {
		u.assertEquals("加点後の得点[68.5, 96.5, 49.0, 73.2, 91.0]", r[3]);
	}

	@Test
	@DisplayName("Question19-3のテスト")
	void test3() {
		u.assertEquals("haruo 49.0", r[4]);
		u.assertEquals("natsuko 73.2", r[5]);
		u.assertEquals("aki 91.0", r[6]);
	}
	
}
