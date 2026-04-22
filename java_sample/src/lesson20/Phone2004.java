package lesson20;

/**
 * 携帯電話クラス
 */
public class Phone2004 {
	/** データ通信量 */
    protected double data;

    /**
     * データ通信量を設定
     *
     * @param data 通信量
     */
    public void setData(double data) {
        this.data = data;
    }

    /**
     * データ通信量を表示
     */
    public void checkData() {
        System.out.println("データ通信量は" + data + "GB です。");
    }
}
