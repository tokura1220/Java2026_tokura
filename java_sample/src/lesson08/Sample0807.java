package lesson08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample0807 {
    public static void main(String[] args) throws IOException {
        System.out.println("整数を入力してください。");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String str = reader.readLine();
        int num = Integer.parseInt(str);

        switch (num) {
        case 4:
            System.out.println("4が入力されました。");
        case 7:
            System.out.println("7が入力されました。");
        }
    }
}
