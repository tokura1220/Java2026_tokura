package lesson13;

/**
 * 携帯電話クラス
 */
public class Phone1301 {
    /** 携帯電話の料金 */
    int fee;

    /** 携帯電話のデータ通信量 */
    double data;
    String iro;
    void show () {
    	System.out.println("料金は" + fee + "円です。");
		System.out.println("データ通信量は" + data + "GBです。");
		System.out.println("携帯の色は" + iro + "です。");

    }

	
}
