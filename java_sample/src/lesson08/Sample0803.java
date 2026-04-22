package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0803 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int res = Integer.parseInt(str);

        if (res > 4) { // ①変数resが4より大きい
            if (res <= 10) { // ②変数resが10以下
                System.out.println(res + "は4より大きく10以下の数字です。");
            }
        }
        System.out.println("システムを終了します。");
    }
}
