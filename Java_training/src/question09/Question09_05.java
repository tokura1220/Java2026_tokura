package question09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class Question09_05 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(newInputStreamReader(System.in));
		System.out.println("1か2を入力してください");
		String str = br.readLine();
		int num = Integer.parseInt(str);
		System.out.println("もう一度1か2を入力してください");
		String str2 = br.readLine();
		int num2 = Integer.parseInt(str2);
		if (num == 1) {
		if (num2 == 1) {
		System.out.println("1が2回入力されました");
		}
		// TODO 自動生成されたメソッド・スタブ

	}

}

	private static Reader newInputStreamReader(InputStream in) {
		// TODO 自動生成されたメソッド・スタブ
		return null;
	}
