package lesson09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0910 {
    public static void main(String[] args) throws IOException {
        System.out.println("何回目の繰り返しで中止しますか？(1～10)");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        for (int i = 1; i <= 10; i++) {
            System.out.println(i + "回繰り返しました。");
            if (i == num) {
                // 変数iが変数numと等しい場合、繰り返しを中断する
                break;
            }
        }
        
        System.out.println("繰り返しを中断しました。");
    }
}
