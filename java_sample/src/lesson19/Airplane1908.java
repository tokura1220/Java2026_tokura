package lesson19;

/**
 * 飛行機クラス
 */
public class Airplane1908 {
    /** 機体番号 */
    private int no;

    /** 定員人数 */
    private int capacity;

    /** 初期値を設定する */
    public Airplane1908() {
        no = 0;
        capacity = 0;
    }

    /**
     * 飛行機の情報を設定
     * @param no 機体番号
     * @param capacity 定員人数
     */
    public void setAirplane(int no, int capacity) {
        this.no = no;
        this.capacity = capacity;
    }

    /**
     * 飛行機の情報を表示
     */
    public void showAirplane() {
        System.out.println("機体番号：No." + no);
        System.out.println("定員：" + capacity + "名");
    }
}
