package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0806 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        switch (num) {
        case 4:
            // 変数numが4の場合の処理
            System.out.println("4が入力されました。");
            break;
        case 7:
            // 変数numが7の場合の処理
            System.out.println("7が入力されました。");
            break;
        default:
            // 変数numが上記以外の場合
            System.out.println("4と7以外の数字が入力されました。");
            break;
        }
    }
}
