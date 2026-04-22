package kakunin03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * while文による繰り返し
 */
public class Question07 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 1
		
		int num = -1;
		
		while( num<1 ||num > 3 ) {
			System.out.println("1〜3の整数を入力:");
			String choice = br.readLine();
	        num = Integer.parseInt(choice);
			
			if(num > 3) {
				System.out.println("範囲外です");
			}
			System.out.print("運勢:");
			switch (num){
			case 1:
				System.out.println("大吉");
				break;
			case 2:
				System.out.println("吉");
				break;
			case 3:
				System.out.println("凶");
				break;
			}
			
			
		}

		// 2
		int stock = 2;
		int quantity = 0;
		int input = 0;
		
		do {
		
			System.out.println("購入しますか？ はい:0 いいえ:1＞");
			String choice = br.readLine();
	        input = Integer.parseInt(choice);
	        
	        if(input == 0) {
	        
	        	if(stock >= 1) {
		        	//1以上
	        		stock--;
		        	quantity++;
		        	
		        }else{
		        	//在庫なしの場合
		        	System.out.println("在庫がありません。");
		        	break;
		        }
	        }

		}while(input == 0);{
			System.out.println("購入数:" + quantity);
		}

	}
}
