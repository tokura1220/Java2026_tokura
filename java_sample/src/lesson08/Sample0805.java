package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0805 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        if (num == 4) {
            // ①numが4と等しい場合の処理
            System.out.println("4が入力されました。");

        } else if (num == 7) {
            // ②numが7と等しい場合の処理
            System.out.println("7が入力されました。");
        } else {
            // ③いずれの条件も満たさない場合の処理
            System.out.println("4と7以外の数字が入力されました。");
        }
    }
}
