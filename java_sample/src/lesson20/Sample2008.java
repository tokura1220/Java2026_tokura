package lesson20;

public class Sample2008 {
    public static void main(String[] args) {
    	// 携帯電話クラスのオブジェクト1を生成
        Phone2008 phone1 = new Phone2008();
        // 携帯電話クラスのオブジェクト2を生成
        Phone2008 phone2 = new Phone2008();
        // 携帯電話クラスのクラス型の変数にオブジェクト1を代入
        Phone2008 phone3 = phone1;

        boolean bl1 = phone1.equals(phone2);
        boolean bl2 = phone1.equals(phone3);
        System.out.println("phone1とphone2が同じオブジェクトか調べた結果:" + bl1);
        System.out.println("phone1とphone3が同じオブジェクトか調べた結果:" + bl2);
    }
}
