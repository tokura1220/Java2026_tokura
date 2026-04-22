package kakunin05.question12;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question12Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question12-1のテスト")
	void test1() {
		u.assertEquals("【スクール開講】座席数:4", r[0]);
	}

	@Test
	@DisplayName("Question12-2のテスト")
	void test2() {
		u.assertEquals("【入学希望者】番号:10 名前:太郎", r[1]);
		u.assertEquals("【入学希望者】番号:11 名前:花子", r[2]);
		u.assertEquals("【入学希望者】番号:12 名前:春男", r[3]);
		u.assertEquals("【入学希望者】番号:-1 名前:なし", r[4]);
	}

	@Test
	@DisplayName("Question12-3のテスト")
	void test3() {
		u.assertEquals("【座席案内】席1 名前:太郎", r[5]);
		u.assertEquals("【座席案内】席2 名前:花子", r[6]);
		u.assertEquals("【座席案内】席3 名前:春男", r[7]);
	}
	
}
