package lesson25;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Sample2505 {
    public static void main (String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("好きな単語を入力してください＞");

        // 入力待ち
        String input = reader.readLine();

        // クラス名を通してクラスメソッドを参照（staticメソッド）
        WordChecker2505.checkNGWord(input);
    }
}
