package question06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question06_01 {

	public static void main(String[] args) throws IOException {
		
		System.out.println("こんばんは");
		
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String time = reader.readLine();
		int time2 = Integer.parseInt(time);
		
		System.out.println("こんばんは夜の" + time2 + "時です");
		
		// TODO 自動生成されたメソッド・スタブ

	}

}
