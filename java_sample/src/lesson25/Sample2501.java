package lesson25;

public class Sample2501 {
    public static void main(String[] args) {
        calc();
    }

    // 計算を実行する
    public static void calc() {
        // 以下の処理で例外が発生
        int a = 3 / 0;
        System.out.println("答えは" + a + "です。");
    }
}
