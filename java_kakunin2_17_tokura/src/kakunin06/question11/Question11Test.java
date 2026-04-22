package kakunin06.question11;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question11Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question11-1のテスト")
	void test1() {
		u.assertEquals("席1に登録しました。", r[0]);
		u.assertEquals("席1 番号:10 名前:太郎", r[1]);
		u.assertEquals("席2に登録しました。", r[2]);
		u.assertEquals("席2 番号:11 名前:花子", r[3]);
		u.assertEquals("席3に登録しました。", r[4]);
		u.assertEquals("席3 番号:12 名前:春男", r[5]);
	}

	@Test
	@DisplayName("Question11-2のテスト")
	void test2() {
		u.assertEquals("---席2の学生---", r[6]);
		u.assertEquals("番号:11 名前:花子", r[7]);
	}

	@Test
	@DisplayName("Question11-3のテスト")
	void test3() {
		u.assertEquals("---学生リスト---", r[8]);
		u.assertEquals("番号:10 名前:太郎", r[9]);
		u.assertEquals("番号:11 名前:花子", r[10]);
		u.assertEquals("番号:12 名前:春男", r[11]);
	}

}
