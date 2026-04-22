package lesson25;

public class Sample2502 {
    public static void main(String[] args) {
        try {
        	calc();
        } catch (ArithmeticException e) {
            System.out.println("計算中に例外が発生しました。");

        } finally {
            System.out.println("終了しました。");
        }
    }

    // 計算を実行する
    public static void calc() {
        // 以下の処理で例外が発生
        int a = 3 / 0;
        System.out.println("答えは" + a + "です。");
    }
}
