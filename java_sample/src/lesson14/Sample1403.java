package lesson14;

public class Sample1403 {
    public static void main(String[] args) {
        //携帯電話クラスのオブジェクトを生成
        Phone1403 phone = new Phone1403();

        // 実引数を渡してメソッドを呼び出す
        phone.searchName("田中");
        phone.searchName("鈴木");
        phone.searchName("佐藤");

        phone.call(1234567890);
        phone.call(1122223333);
    }
}

