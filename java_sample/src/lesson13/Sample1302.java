package lesson13;

public class Sample1302 {
    public static void main(String[] args) {
        // 人間クラスのオブジェクトを生成
        Human1302 human = new Human1302();
        // 携帯電話クラスのオブジェクトを生成
        Phone1302 phone = new Phone1302();

        // 人間クラスのフィールドnameに値を代入
        human.name = "田中太郎";
        // 人間クラスのフィールドphoneに携帯電話クラスのオブジェクトを代入
        human.phone = phone;
        // 人間クラスのフィールドphone内のフィールドfeeに値を代入
        human.phone.fee = 5000;

        // フィールドの値を出力
        System.out.println("料金は" + human.phone.fee + "円です。");
        System.out.println("携帯電話の持ち主は" + human.name + "さんです。");
    }
}
