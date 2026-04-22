package lesson14;

/**
 * 携帯電話クラス
 */
public class Phone1403 {
    /**
     * 名前を検索
     *
     * @param n 名前
     */
    public void searchName(String n) {
        System.out.println("アドレス帳から" + n + "さんを検索します。");
    }

    /**
     * 電話をかける
     *
     * @param pn 電話番号
     */
    public void call(int pn) {
        System.out.println(pn + "へ電話をかけます。");
    }
}
