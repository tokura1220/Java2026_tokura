package lesson23;

/**
 * 教師クラス
 */
public class Teacher2301 extends Worker2301 {
	/**
     * コンストラクタ
     * @param name 氏名
     * @param age 年齢
     */
    public Teacher2301(String name, int age) {
        super(Constant2301.TEACHER, name, age);
    }

    /**
    * 仕事内容の表示
    */
    public void doWork() {
        System.out.println("知識を教えます。");
    }
}
