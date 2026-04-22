package lesson09;

public class Sample0906 {
    public static void main(String[] args) {
        int[] tests = { 45, 80, 76, 56, 55 };

        // 1回の繰り返しごとに、要素の値が変数valueに代入される
        for (int value : tests) {
            System.out.println(value);
        }
    }
}
