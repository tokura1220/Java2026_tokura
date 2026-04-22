package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0911 {
    public static void main(String[] args) throws IOException {
        System.out.println("何回目の繰り返しを中断しますか？(1～10)");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();
        int num = Integer.parseInt(str);

        for (int i = 1; i <= 10; i++) {
            if (i == num) {
                // 残りの処理を行わずに次の繰り返しに移動する
                continue;
            }
            System.out.println(i + "回繰り返しました。");
        }
    }
}
