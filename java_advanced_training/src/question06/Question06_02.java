package question06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Question06_02 {

	public static void main(String[] args) throws IOException{
		
		System.out.println("整数を入力してください。");
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);
        
        
		if(num%10 == 0 ) {
			System.out.println(num + "は10の倍数です。");
			
		}else {
			System.out.println(num	+ "は10の倍数ではありません。");
			
		}
		// TODO 自動生成されたメソッド・スタブ

	}

}
