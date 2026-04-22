package lesson10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample1001 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数値を入力してください。");

        // 数字の入力処理
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        int num = Integer.parseInt(str);

        // 入力された数値を確認し、それに応じて異なる文字列を出力
        if (num < 0) {
            System.out.println(num + "：0未満の値です。");
        } else if (0 <= num && num < 10) {
            System.out.println(num + "：0以上10未満の値です。");
        }

        System.out.println("以上で処理は終了です。");
    }
}
