package lesson15;

/**
 * 携帯電話クラス
 */
public class Phone1501 {
	/** 料金 */
	private int fee;
	/** データ通信量 */
	private double data;

	/**
	 * 料金を設定
	 *
	 * @param f 料金
	 */
	public void setFee(int f) {
		// 料金の値チェック
		if (0 <= f) {
			fee = f;
			System.out.println("料金を" + fee + "円にしました。");
		} else {
			System.out.println(f + "は正しい値ではありません。");
		}
	}

	/**
	 * データ通信量を設定
	 *
	 * @param d データ通信量
	 */
	public void setData(double d) {
		// データ通信量の値チェック
		if (0.0 <= d && d <= 99.99) {
			data = d;
			System.out.println("データ通信量を" + data + "GBにしました。");
		} else {
			System.out.println(d + "は正しい値ではありません。");
		}
	}
}

