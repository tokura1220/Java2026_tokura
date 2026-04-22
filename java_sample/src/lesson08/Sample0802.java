package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0802 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int res = Integer.parseInt(str);

        if (res == 5) {
            // resの値が5だった場合、以下の処理を実行
            System.out.println("5が入力されました。");
            System.out.println("式の評価値は「true」です。");
        }

        System.out.println("システムを終了します。");
    }
}
