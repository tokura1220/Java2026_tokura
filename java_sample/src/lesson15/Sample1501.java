package lesson15;

public class Sample1501 {
    public static void main(String[] args) {
        // 携帯電話クラスのオブジェクトを生成
        Phone1501 phone = new Phone1501();

        // 想定通りの値を指定した場合
        phone.setFee(5000);
        phone.setData(2.0);

        System.out.println("誤ったデータ通信量を設定します。");

        // 想定外の値を指定した場合
        phone.setFee(-10000);
        phone.setData(9999.99);
    }
}

