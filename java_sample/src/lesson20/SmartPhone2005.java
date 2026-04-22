package lesson20;

/**
 * スマートフォンクラス
 */
public class SmartPhone2005 extends Phone2005 {
	/** 液晶サイズ */
    private int inch;

    /**
     * コンストラクタ
     *
     */
    public SmartPhone2005() {
        System.out.println("スマートフォンを生成しました。");
        inch = 5;
    }

    /**
     * 液晶サイズを表示
     */
    @Override
    public void show() {
        System.out.println("液晶画面のサイズは" + inch + "インチです。");
    }
}
