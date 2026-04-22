package lesson19;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Sample1905 {
    public static void main(String[] args) {
        // 日付を取得する
        Date date = new Date();

        // 書式化文字列を指定する
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println("今日の日付を表示します。");
        System.out.println(sdf.format(date));
    }
}
