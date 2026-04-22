package lesson14;

public class Sample1406 {
    public static void main(String[] args) {
        Human1406 satou = new Human1406();

        // 戻り値を持つメソッドを呼びだし、戻り値を変数に代入
        String fullName = satou.sayFullName("佐藤", "一郎");
        double bmi = satou.calcBmi(70.0, 175.0);

        System.out.println(fullName + "のBMIは" + bmi + "です");
    }
}

