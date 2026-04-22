package kakunin02;

/**
 * 配列
 */
public class Question04 {
	public static void main(String[] args) {

		// 1
		int[] a;
		a = new int[2];
		
		a[1] = -5;
		
		System.out.println("要素1:" + a[0] + " 要素2:" + a[1] );

		// 2
		String[] b;
		b = new String[3];
		
		b[0] = ("data");
		b[1] = ("");
		b[2] = ("null");
		
		System.out.println("①" + b[0] + " ②" + b[1] + " ③" + b[2] );

		// 3
		boolean[] c;
		c = new boolean[5];
		
		c[4] = (true);
		
		System.out.println("配列cの最後の値:"  + c[4] );


		// 4
		double[][] d = {{46, 93.5, 88},{81,70.2,}};
		
		
		System.out.println("クラス1最高点:" + d[0][1] + " クラス2最高点:" + d[1][0] );


	}
}
