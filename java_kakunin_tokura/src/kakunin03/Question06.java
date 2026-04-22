package kakunin03;

/**
 * for文による繰り返し
 */
public class Question06 {
	public static void main(String[] args) {
		
		// 既存の配列[num] (学生番号)
		int[] num = { 10, 11, 12, 13, 14 };
		// 既存の配列[name] (学生名)
		String[] name = { "太郎", "花子", "春男", "夏子", "あき" };
		// 既存の配列[score] (得点)
		double[] score = { 65.5, 93.5, 46, 70.2, 88 };
		// 既存の配列[isCleared] (判定結果)
		boolean[] isCleared = new boolean[num.length];
		
		// 1
		for(int i = 0; i < 5; i++) {
			System.out.println(num[i] +" "+ name[i] + " " + score[i]);
		}
		// 2
		double mean = 0;
		int count = 0;
		for ( double sum: score) {
			mean += sum;
			count++;
		}
		int mean1 = (int) mean;
		System.out.print("合計:" + mean );
		System.out.println(" 平均:" + (mean1 / count));

		// 3
		String[] hantei = new String[num.length]; 
		for( int i = 0;i < 5; i++ ) {
			
			isCleared[i] = ((score[i]>=60)?true:false);
			hantei[i] = ((isCleared[i] == true) ? "合格":"不合格"); 
			
			if(name[i]. equals("夏子")) {
				System.out.println(name[i] + "の判定結果:" + hantei[i]);
			}
		}
		
	}
}
