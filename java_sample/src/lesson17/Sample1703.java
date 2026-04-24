package lesson17;

public class Sample1703 {
    public static void main(String[] args) {
        // 犬クラスのオブジェクトを生成してコンストラクタ（引数あり）を呼び出す
        Dog1703 dog;
        Dog1703 dog2;
        
        dog = new Dog1703("秋田犬");
        // 性別と犬種の値を出力
        dog.show();
        dog2 = new Dog1703("ボルゾイ");
        dog2.show();
        dog.show();
    }
}

