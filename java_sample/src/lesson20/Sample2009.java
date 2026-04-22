package lesson20;

public class Sample2009 {

	public static void main(String[] args) {

		//String型のstr1を作成
		String str1 = "test";
		//str1が保存されたStringBuilderクラスのオブジェクトを作成
		StringBuilder stringBuilder = new StringBuilder(str1);
		//StringBuilder型からString型に変換
		String str2 = stringBuilder.toString();
		//str1とstr2の値を確認する
		System.out.println("str1:" + str1);
		System.out.println("str2:" + str2);

		//同じ"test"が含まれている二つの文字列型を==(等値比較)での比較
		System.out.println("==での比較結果:" + (str1 == str2));
		//同じ"test"が含まれている二つの文字列型をequals()(等価比較)での比較
		System.out.println("equals()での比較結果:" + str1.equals(str2));

	}

}