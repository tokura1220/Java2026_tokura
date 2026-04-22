package lesson20;

/**
 * 携帯電話クラス
 */
public class Phone2008 {
	/** 料金 */
    private int fee;
    /** データ通信量 */
    private double data;

    /**
     * コンストラクタ
     */
    public Phone2008() {
        setFee(0);
        setData(0.0);
        System.out.println("携帯電話を購入しました。");
    }

	public double getData() {
		return data;
	}

	public void setData(double data) {
		this.data = data;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}
}
