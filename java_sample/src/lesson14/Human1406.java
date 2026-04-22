package lesson14;

public class Human1406 {

    /**
     * フルネームを取得
     *
     * @param sei 姓
     * @param mei 名
     * @return フルネーム
     */
    String sayFullName(String sei, String mei) {
        String fullName = sei + mei;
        return fullName;
    }

    /**
     * BMIを計算する
     *
     * @param weight 体重
     * @param height 身長
     * @return BMI
     */
    double calcBmi(double weight, double height) {
        double bmi = weight / ((height / 100) * (height / 100));
        return bmi;
    }
}
