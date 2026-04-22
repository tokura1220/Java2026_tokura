package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0905 {
    public static void main(String[] args) throws IOException {
        System.out.println("いくつまでの合計を求めますか？");

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        // 総和を保存する変数
        int sum = 0;

        //  iが入力値以下の場合、繰り返す
        for (int i = 1; i <= num; i++) {
            // sumにiを加算代入する
            sum += i;
        }
        System.out.println("1から" + num + "までの合計は" + sum + "です。");
    }
}
