package lesson17;

public class Sample1702 {
    public static void main(String[] args) {
        // 犬クラスのオブジェクトを生成してコンストラクタ（引数なし）を呼び出す
        Dog1702 dog1 = new Dog1702();

        // 性別と犬種の値を出力
        dog1.show();

        // 犬クラスのオブジェクトを生成してコンストラクタ（引数あり）を呼び出す
        Dog1702 dog2 = new Dog1702("メス", "トイプードル");

        // 性別と犬種の値を出力
        dog2.show();
    }
}

