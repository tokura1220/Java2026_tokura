package lesson20;

/**
 * スマートフォンクラス
 */
public class SmartPhone2003 extends Phone2003 {
    /**
     * コンストラクタ
     */
    public SmartPhone2003() {
        // スーパークラスのコンストラクタ（引数あり）を呼び出す
        super(5000, 2.0);

        System.out.println("SmartPhoneクラスのコンストラクタを呼び出しました。");
    }
}

