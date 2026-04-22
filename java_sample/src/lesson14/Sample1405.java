package lesson14;

public class Sample1405 {
    public static void main(String[] args) {
        // 人間クラスのオブジェクトを生成
        Human1405 human = new Human1405();

        // 1つ目の携帯電話クラスのオブジェクトを生成
        Phone1405 phone1 = new Phone1405();
        phone1.phoneName ="ApplePhone";

        // 2つ目の携帯電話クラスのオブジェクトを生成
        Phone1405 phone2 = new Phone1405();
        phone2.phoneName ="AndroidPhone";

        // 参照型を引数に持つメソッドを呼び出す
        human.buyPhone(phone1);
        human.buyPhone(phone2);
    }
}

