package lesson14;

public class Sample1402 {
    public static void main(String[] args) {
    	 // 携帯電話クラスのオブジェクトを生成
        Phone1402 phone = new Phone1402();

        // フィールドに値を代入
        phone.fee = 5000;
        phone.data = 2.0;

        // 料金とデータ通信量を表示
        phone.show();
    }
}
