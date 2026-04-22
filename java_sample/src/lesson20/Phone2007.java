package lesson20;

/**
 * 携帯電話クラス
 */
public class Phone2007 {
	/** 料金 */
    private int fee;
    /** データ通信量 */
    private double data;

    /**
     * コンストラクタ
     *
     */
    public Phone2007() {
        fee = 0;
        data = 0.0;
        System.out.println("携帯電話を購入しました。");
    }

    /**
     * 料金とデータ通信量を設定し、表示
     *
     * @param f 料金
     * @param d データ通信量
     */
    public void setPhone(int f, double d) {
        fee = f;
        data = d;
        System.out.println("料金は" + fee + "円でデータ通信量は" + data + "GBです。");
    }

    /**
     * 文字列を戻り値として、返す
     * @return 文字列
     */
@Override
    public String toString() {
        String str = "料金:" + fee + "データ通信量:" + data;
        return str;
    }
}
