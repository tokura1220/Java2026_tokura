package kakunin06.question14;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question14Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question14-1のテスト")
	void test1() {
		u.assertEquals("【スクール開講】座席数:5", r[0]);
		u.assertEquals("席1 10 太郎 2004/08/10 taro@aa.jp 65.5", r[1]);
		u.assertEquals("席2 11 花子 2004/04/15 hana@bb.com 93.5", r[2]);
		u.assertEquals("席3 12 春男 2001/03/26 haru@cc.us 46.0", r[3]);
		u.assertEquals("席4 13 夏子 2004/08/10 natsu@dd.org 70.2", r[4]);
		u.assertEquals("席5 14 あき 2003/10/24 aki@ee.com 88.0", r[5]);
	}

	@Test
	@DisplayName("Question14-2のテスト")
	void test2() {
		u.assertEquals("---名前リスト---", r[6]);
		u.assertEquals("太郎(taro)", r[7]);
		u.assertEquals("花子(hana)", r[8]);
		u.assertEquals("春男(haru)", r[9]);
		u.assertEquals("夏子(natsu)", r[10]);
		u.assertEquals("あき(aki)", r[11]);
	}

	@Test
	@DisplayName("Question14-3のテスト")
	void test3() {
		u.assertEquals("---テスト結果---", r[12]);
		u.assertEquals("最高点:93.5", r[13]);
		u.assertEquals("平均点:72.6", r[14]);
		u.assertEquals("最低点:46.0", r[15]);
	}
	
}
