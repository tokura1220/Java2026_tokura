package kakunin03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question07Test {

	private static TestUtil u;
	private static String[] r;

	@Test
	@DisplayName("Question07-1(整数が範囲内)のテスト")
	void test1() throws Exception {
		u = new TestUtil();
		u.append("2");
		u.append("1");
		u.setIn();
		Question07.main(null);
		r = u.printByArray();
		u.assertEquals("1〜3の整数を入力:", r[0]);
		u.assertEquals("運勢:吉", r[1]);
	}

	@Test
	@DisplayName("Question07-1(整数が範囲外)のテスト")
	void test2() throws Exception {
		u = new TestUtil();
		u.append("4");
		u.append("3");
		u.append("1");
		u.setIn();
		Question07.main(null);
		r = u.printByArray();
		u.assertEquals("範囲外です", r[1]);
	}
	
	@Test
	@DisplayName("Question07-2(在庫あり)のテスト")
	void test3() throws Exception {
		u = new TestUtil();
		u.append("1");
		u.append("0");
		u.append("1");
		u.setIn();
		Question07.main(null);
		r = u.printByArray();
		u.assertEquals("購入しますか？ はい:0 いいえ:1＞", r[3]);
		u.assertEquals("購入数:1", r[4]);
	}
	
	@Test
	@DisplayName("Question07-2(在庫なし)のテスト")
	void test4() throws Exception {
		u = new TestUtil();
		u.append("1");
		u.append("0");
		u.append("0");
		u.append("0");
		u.setIn();
		Question07.main(null);
		r = u.printByArray();
		u.assertEquals("在庫がありません。", r[5]);
		u.assertEquals("購入数:2", r[6]);
	}
}
