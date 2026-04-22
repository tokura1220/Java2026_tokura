package kakunin05.question09;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question09Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question09-1のテスト")
	void test1() {
		u.assertEquals("10番、太郎です。", r[0]);
		u.assertEquals("11番、花子です。", r[1]);
		u.assertEquals("12番、春男です。", r[2]);
		u.assertEquals("13番、夏子です。", r[3]);
	}

	@Test
	@DisplayName("Question09-2のテスト")
	void test2() {
		u.assertEquals("席1に登録しました。", r[4]);
		u.assertEquals("席2に登録しました。", r[5]);
		u.assertEquals("席3に登録しました。", r[6]);
		u.assertEquals("教室が一杯です。", r[7]);
	}

	@Test
	@DisplayName("Question09-3のテスト")
	void test3() {
		u.assertEquals("---席順リスト---", r[8]);
		u.assertEquals("席1 番号:10 名前:太郎", r[9]);
		u.assertEquals("席2 番号:11 名前:花子", r[10]);
		u.assertEquals("席3 番号:12 名前:春男", r[11]);
	}
	
}
