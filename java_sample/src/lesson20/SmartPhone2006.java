package lesson20;

/**
 * スマートフォンクラス
 */
public class SmartPhone2006 extends Phone2006 {
	/** 液晶サイズ */
    private int inch;

/**
     * コンストラクタ
     *
     */
    public SmartPhone2006() {
        super.fee = 8000;
        super.data = 5.0;
        this.inch = 5;
    }

    /**
     * 液晶サイズを表示
     */
    @Override
    public void show() {
        System.out.println("購入したスマートフォンの色は黒です。");
        System.out.println("液晶画面のサイズは" + inch + "インチです。");
        super.show();
    }
}
