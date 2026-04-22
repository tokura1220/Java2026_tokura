package lesson23;

/**
 * 警察官クラス
 */
public class Police2301 extends Worker2301 {
	/**
     * コンストラクタ
     *
     * @param name 氏名
     * @param age 年齢
     */
    public Police2301(String name, int age) {
        super(Constant2301.POLICE, name, age);
    }

    /**
    * 仕事内容の表示
    */
    public void doWork() {
        System.out.println("地域や人々の安全を守ります。");
    }
}
