package lesson20;

/**
 * 携帯電話クラス
 */
public class Phone2003 {
    /** 料金 */
    int fee;
    /** データ通信量 */
    double data;

    /**
     * コンストラクタ
     *
     * @param fee 料金
     * @param data 通信量
     */
    public Phone2003(int fee, double data) {
        System.out.println("Phoneクラスのコンストラクタ（引数あり）が呼び出されました。");
        this.fee = fee;
        this.data = data;
    }
}

