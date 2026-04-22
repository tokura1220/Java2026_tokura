package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sample1907 {
    public static void main(String[] args) throws IOException {
        System.out.println("電話番号を入力してください");
        System.out.println("入力例:xxx-xxxx-xxxx");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = reader.readLine();

        // パターンを指定
        Pattern p = Pattern.compile("^[0-9]{3}-[0-9]{4}-[0-9]{4}$");
        // パターンにマッチしているか比較
        Matcher m = p.matcher(str);
        System.out.println(m.find());
    }
}
