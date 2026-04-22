package lesson06;

public class Sample0602 {
    public static void main(String[] args) {
        int num1 = 3;
        int num2 = 5;

        // ① num1+num2の値をsumに代入
        int sum = num1 + num2;

        System.out.println("変数num1の値は" + num1 + "です。");
        System.out.println("変数num2の値は" + num2 + "です。");
        System.out.println("num1+num2の値は" + sum + "です。");

        // ② num1+1の値をnum1に代入
        num1 = num1 + 1;

        System.out.println("変数num1の値に1を足すと" + num1 + "です。");
    }
}
