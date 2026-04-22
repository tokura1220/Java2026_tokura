package lesson14;

public class Sample1404 {
    public static void main(String[] args) {
        // 携帯電話クラスのオブジェクトを生成
        Phone1404 phone = new Phone1404();

        String name = "田中";
        int phoneNumber = 1234567890;

        // 複数の引数を持つメソッドを呼び出す
        phone.entryAddressBook(name, phoneNumber);
    }
}
