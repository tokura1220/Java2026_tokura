package lesson19;

public class Sample1908 {
    public static void main(String[] args) {

    	// 飛行機クラスのオブジェクトを生成
        Airplane1908 airplane1 = new Airplane1908();
        airplane1.setAirplane(1111, 30);

        // 変数airplane1の値を代入
        Airplane1908 airplane2 = airplane1;

        airplane2.setAirplane(2222, 50);

        // 飛行機の情報を表示
        airplane1.showAirplane();

        // 飛行機の情報を表示
        airplane2.showAirplane();
    }
}
