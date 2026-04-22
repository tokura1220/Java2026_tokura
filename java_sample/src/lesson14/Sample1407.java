package lesson14;

public class Sample1407 {
    public static void main(String[] args) {
        // 人間クラスのオブジェクトを生成
        Human1407 satou = new Human1407();

        // 戻り値を持つメソッドを呼び出し、戻り値を変数に代入
        String[] showHobbies = satou.tellHobbies();

        // 変数の中身を繰り返して表示
        for (int i = 0; i < showHobbies.length; i++) {
            System.out.println((i + 1) + "つ目の趣味は" + showHobbies[i] + "です。");
        }
    }
}

