package lesson13;

public class Sample1301 {

	public static void main(String[] args) {
		// 携帯電話クラスのオブジェクトを生成
		Phone1301 phone = new Phone1301();

		// フィールドに値を代入
		phone.fee = 5000;
		phone.data = 2.0;

		// フィールドの値を出力
		System.out.println("料金は" + phone.fee + "円です。");
		System.out.println("データ通信量は" + phone.data + "GBです。");
	}
}
