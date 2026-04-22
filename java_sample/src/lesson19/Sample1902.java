package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample1902 {
    public static void main(String[] args) throws IOException {
        // 追加される文字列を入力
        System.out.println("１つ目の文字列を入力して下さい。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str1 = reader.readLine();

        // 追加する文字列を入力
        System.out.println("２つ目の文字列を入力して下さい。");
        String str2 = reader.readLine();
        StringBuilder builder = new StringBuilder(str1);

        // 文字列を追加する
        builder.append(str2);
        System.out.println("2つの文字列を繋げた結果は" + builder + "です。");
    }
}
