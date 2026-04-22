package lesson20;

public class Sample2004 {
    public static void main(String[] args) {
        double data = 2.5;
        // スマートフォンクラスのオブジェクトを生成
        SmartPhone2004 sp = new SmartPhone2004();

        // スマートフォンの通信量設定するメソッドを呼びだす
        sp.setData(data);
        // スマートフォンの通信量表示するメソッドを呼びだす
        sp.checkData();

        System.out.println("データ通信量を変更します。");
        // スマートフォンの通信量変更するメソッドを呼びだす
        sp.doubleData();
        // スマートフォンの通信量表示するメソッドを呼びだす
        sp.checkData();
    }
}
