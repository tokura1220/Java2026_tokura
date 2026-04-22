package kakunin08.question18;

import static org.junit.jupiter.api.Assertions.*;

import java.text.ParseException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lib.TestUtil;

class Question18Test {

	private static TestUtil u;

	@Test
	@DisplayName("Question18-1のテスト")
	void test1() {
		assertThrows(NullPointerException.class, () -> { Main1.main(new String[]{"1"}); });
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> { Main1.main(new String[]{"2"}); });
	}

	@Test
	@DisplayName("Question18-2のテスト")
	void test2() {
		assertThrows(ParseException.class, () -> { Main2.main(null); });
	}

	@Test
	@DisplayName("Question18-3のテスト")
	void test3() {
		u = new TestUtil();
		u.setErr();
		Main3.main(null);
		var a = u.printAll();
		var r = a.split(System.lineSeparator());
		u.assertEquals("計算を行います。", r[0]);
		u.assertEquals("java.lang.ArithmeticException: / by zero", r[1]);
		u.assertTrue(a.contains("計算を終了します。"), a);
		u.setDefault();
	}

	@Test
	@DisplayName("Question18-4のテスト")
	void test4() {
		u = new TestUtil();
		Main4.main(new String[]{"1"});
		var r = u.printByArray();
		u.assertEquals("非チェック例外が発生!", r[0]);
		u = new TestUtil();
		Main4.main(new String[]{"2"});
		r = u.printByArray();
		u.assertEquals("チェック例外が発生!", r[0]);
	}

	@Test
	@DisplayName("Question18-5のテスト")
	void test5() {
		u = new TestUtil();
		Main5.main(null);
		var r = u.printByArray();
		u.assertEquals("【B】例外をキャッチ", r[0]);
		u.assertEquals("【B】Aクラスに報告します!", r[1]);
		u.assertEquals("【A】例外をキャッチ", r[2]);
		u.assertEquals("【B】「【C】例外発生!」だそうです!", r[3]);
		u.assertEquals("【A】...静観しましょう。", r[4]);
	}

}
