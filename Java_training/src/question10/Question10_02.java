package question10;

public class Question10_02 {

	public static void main(String[] args) {
		
		int i = 0;
		System.out.println("1回目の繰り返し処理です");
		
		while(i < 5) {
			i++;
			 System.out.println((i) + "回目");
		}
		System.out.println("2回目の繰り返し処理です");
		while(i > 0) {
			i--;
			 System.out.println((i + 1) + "回目");
		}
		System.out.println("処理を終了します");
		

	}

}
