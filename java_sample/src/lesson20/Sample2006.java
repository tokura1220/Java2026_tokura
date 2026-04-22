package lesson20;

public class Sample2006 {
    public static void main(String[] args) {
        // スーパークラスの配列を作成
        Phone2006[] phones = new Phone2006[2];

        // スーパークラスのオブジェクトを配列に追加
        phones[0]= new Phone2006();

        // サブクラスのオブジェクトを配列に追加
        phones[1]= new SmartPhone2006();

        for (Phone2006 phone : phones) {
            // 各オブジェクトのshow()メソッドが実行される
            phone.show();
        }
    }
}
