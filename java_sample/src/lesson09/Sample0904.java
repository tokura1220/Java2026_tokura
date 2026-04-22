package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0904 {
    public static void main(String[] args) throws IOException {
        System.out.println("いくつ*を出力しますか？");

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        //  iが入力値以下の場合、繰り返す
        for (int i = 1; i <= num; i++) {
            System.out.print("*");
        }
    }
}
