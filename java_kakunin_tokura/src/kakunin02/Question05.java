package kakunin02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 条件分岐
 */
public class Question05 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 

		// 1
		System.out.println("得点を入力:");
		String str = br.readLine();
		
		double score = Double.parseDouble(str);
		

		// 2
		if(score>=90){
			String result = ("秀");
			System.out.println("あなたの成績:" + result);
			
		}else if (score >= 80) {
			String result = ("優");
			System.out.println("あなたの成績:" + result);
			
		}else if (score >= 70){
			String result = ("良");
			System.out.println("あなたの成績:" + result);
			
		}else if (score >= 60){
			String result = ("可");
			System.out.println("あなたの成績:" + result);
			
		}else if (score >= 70){
			String result = ("良");
			System.out.println("あなたの成績:" + result);
			
		}
		
		// 3
		
		System.out.println("成績を入力:");
		String myResult = br.readLine();
		
		String eval;
		switch (myResult) {
		case "不可":
			//
			eval = "不合格";
			
		break;
		default :
			
			eval = "合格";
		break;
		}
		System.out.println("成績判定結果:" + eval);
		
		// 4
		
		System.out.println("出席率を入力:");
		str = br.readLine();
		int attends = Integer.parseInt(str);
		boolean isAppoved;
		
		if((score>=60) && (attends>=80)){
			isAppoved  = true;
			
		}else  { 
			isAppoved  = false;
			
		}
		
		
		System.out.println("単位認定結果:" + ((isAppoved == true) ? "認定" : "不認定"));
		

	}
}
