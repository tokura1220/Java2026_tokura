package lesson20;

/**
 * 携帯電話クラス
 */
public class Phone2001 {
    /** 料金 */
    private int fee;

    /**
     * 料金を設定
     *
     * @param fee 料金
     */
    public void setFee(int fee) {
        this.fee = fee;
    }

    /**
     * 料金を表示
     *
     */
    public void showFee() {
        System.out.println("料金は" + fee + "円です。");
    }
}
