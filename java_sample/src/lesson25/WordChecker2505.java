package lesson25;

/**
 * 文字列比較クラス
 */
public class WordChecker2505 {
	/**
	 * 文字列比較クラス
	 *
	 * @param input 文字列
	 * @throws Exception
	 */
	public static void checkNGWord(String input) throws Exception {
		if ("ITSchool".equals(input)) {
			// 入力された文字列がITSchoolと一致した場合はthrowで例外を投げます。
			throw new Exception("入力された内容がNGワードです");
		} else {
			System.out.println("問題ありません");
		}
	}
}