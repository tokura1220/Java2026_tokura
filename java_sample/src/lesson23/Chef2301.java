package lesson23;

/**
 * 料理人クラス
 */
public class Chef2301 extends Worker2301 {
	/**
     * コンストラクタ
     * @param name 氏名
     * @param age 年齢
     */
    public Chef2301(String name, int age) {
        super(Constant2301.CHEF, name, age);
    }

    /**
     *  仕事内容の表示
     */
    public void doWork() {
        System.out.println("食事を作ります。");
    }
}
