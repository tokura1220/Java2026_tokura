package lesson23;

/**
 * 出力用クラス
 */
public class Display2301 {
	/**
     * 自己紹介と仕事内容の表示
     *
     * @param workers 職業人
     */
    public static void displayWorkers(Worker2301[] workers) {
        for (Worker2301 worker : workers) {
            // 各オブジェクトのメソッドが実行される
            worker.showIntroduction();
            worker.doWork();
        }
    }
}

