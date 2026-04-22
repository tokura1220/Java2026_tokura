package lesson25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Sample2503 {
    public static void main(String[] args) {
        try {
        	String[] name = new String[2];
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("一人目の名前を入力してください。");
            name[0] = reader.readLine();
            System.out.println("二人目の名前を入力してください。");
            name[1] = reader.readLine();

            System.out.println("一人目の名前は"+name[0]+"さんです。");
            System.out.println("二人目の名前は"+name[1]+"さんです。");
            System.out.println("三人目の名前は"+name[2]+"さんです。");

        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
            System.out.println("配列のインデックスが不正です。");
        } catch (IOException e) {
            System.out.println("入出力処理で問題が発生しました。");
        }
    }

}
