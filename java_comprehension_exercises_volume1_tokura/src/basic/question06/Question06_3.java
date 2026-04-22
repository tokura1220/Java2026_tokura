package basic.question06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 第9章 繰り返し
 */
public class Question06_3 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1
		int amount = 0;
		//鉛筆個数

		// 2
		int price = 100;
		//鉛筆値段

		// 3
		System.out.println("鉛筆を購入しますか? ");
		System.out.println("はい：0、いいえ：1 >");
		

		// 4
		String str = br.readLine();
		int buyFlag = Integer.parseInt(str);
		
		// 5
		while(buyFlag == 0) {
			amount++;
			System.out.println("購入する鉛筆の本数を1つ増やしますか？");
			System.out.println("はい：0、いいえ：1 >");
			str = br.readLine();
			buyFlag = Integer.parseInt(str);
		}

		// 6
		System.out.println("購入した鉛筆の本数は" + amount + "本です。");

		// 7
		
		System.out.println("売却した本の合計金額は " + (amount * price) + " 円です。");
		
	}
}
