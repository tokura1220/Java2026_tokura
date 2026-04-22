package kakunin08.question15;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question15Test {
	
	private static TestUtil u;
	private static String[] r;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		u = new TestUtil();
		Main.main(null);
		r = u.printByArray();
	}

	@Test
	@DisplayName("Question15-1のテスト")
	void test1() {
		u.assertEquals("Java大学1年、学籍番号202601、田中です。", r[0]);
	}

	@Test
	@DisplayName("Question15-2のテスト")
	void test2() {
		u.assertEquals("Java大学1年、学籍番号202602、藤田です。", r[1]);
		u.assertEquals("コンビニでバイトしてます。", r[2]);
	}

	@Test
	@DisplayName("Question15-3のテスト")
	void test3() {
		u.assertEquals("Java大学1年、学籍番号202603、山本です。", r[3]);
		u.assertEquals("バンドでギターを担当してます。", r[4]);
	}

	@Test
	@DisplayName("Question15-4のテスト")
	void test4() {
		u.assertEquals("Student [num=202601, name=田中, grade=1]", r[5]);
		u.assertEquals("Student [num=202602, name=藤田, grade=1]", r[6]);
		u.assertEquals("Student [num=202603, name=山本, grade=1]", r[7]);
	}
	
}
