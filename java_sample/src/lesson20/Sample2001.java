package lesson20;

public class Sample2001 {
    public static void main(String[] args) {
    	// スマートフォンクラスのオブジェクトを生成
        SmartPhone2001 sp = new SmartPhone2001();

        // スマートフォンの料金設定するメソッドを呼びだす
        sp.setFee(5000);

        // スマートフォンの料金表示するメソッドを呼びだす
        sp.showFee();

        // スマートフォンの機能利用するメソッドを呼びだす
        sp.smartPhoneFunction();

    }
}
