package kakunin01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 入出力
 */
public class Question02 {
	public static void main(String[] args) 	throws IOException{


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();

        // 入力した文字列を数値に変換
        System.out.println("番号を入力:");
        int num = Integer.parseInt(str);
		

        System.out.println("名前を入力:");
		String name = reader.readLine();
		
		System.out.println("得点を入力:");
		String str1 = reader.readLine();
		//小数点数値に変更
		Double score = Double.parseDouble(str1);
		
		
		System.out.println("番号:" + num + " 名前:" + name + " 得点:"+ score );

	}
}
