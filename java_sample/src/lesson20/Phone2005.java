package lesson20;

/**
 * 携帯電話クラス
 */
public class Phone2005 {
	/** 料金 */
    private int fee;
    /** データ通信量 */
private double data;

	/**
     * コンストラクタ
     *
     */
    public Phone2005() {
        System.out.println("携帯電話を生成しました。");
        fee = 5000;
        data = 2.0;
    }

    /**
     * 料金とデータ通信量を表示
     */
    public void show() {
        System.out.println("携帯電話の料金は、" + fee + "円です。");
        System.out.println("データ通信量は、" + data + "GBです。");
    }
}
