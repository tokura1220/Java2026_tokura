package lesson14;

/**
 * 携帯電話クラス
 */
public class Phone1402 {
    /** 料金 */
    int fee;

    /** データ通信量 */
    double data;

    /**
     * 料金とデータ通信量を表示
     */
    public void show() {
        // 同じクラス内の他のメソッドを呼び出す
        message();

        System.out.println("携帯電話の料金は" + fee + "円です。");
        System.out.println("データ通信量は" + data + "GBです。");
    }

    /**
     * メッセージを表示
     */
    public void message() {
        System.out.println("これから携帯電話の情報を表示します。");

    }
}
