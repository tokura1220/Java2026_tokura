package lesson23;

public class Sample2301 {
    public static void main(String[] args) {
    	// スーパークラスの配列を作成
        Worker2301[] workers = new Worker2301[3];

        // サブクラスのオブジェクトを配列に追加
        // 警察官クラスのオブジェクトを生成して、コンストラクタを呼び出す
        workers[0] = new Police2301("田中", 28);
        // 教師クラスのオブジェクトを生成して、コンストラクタを呼び出す
        workers[1] = new Teacher2301("佐藤", 53);
        // 料理人クラスのオブジェクトを生成して、コンストラクタを呼び出す
        workers[2] = new Chef2301("鈴木", 31);

        // 出力用クラスに各オブジェクト情報を渡す
        Display2301.displayWorkers(workers);
    }
}
