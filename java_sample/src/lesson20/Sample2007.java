package lesson20;

public class Sample2007 {
    public static void main(String[] args) {
    	// 携帯電話クラスのオブジェクトを生成
        Phone2007 p = new Phone2007();

        // 複数の引数を持つメソッドを呼び出す
        p.setPhone(5000, 7.3);

        System.out.println(p);
    }
}
