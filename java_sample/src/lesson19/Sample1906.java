package lesson19;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Sample1906 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String inputDateString;

        do {
            System.out.println("「yyyy/MM/dd」の形式で日付を入力してください。");

            inputDateString = reader.readLine();

            // isIllegalDate()メソッドで日付チェックを行ない、
            // 不正な日付の場合（戻り値がtrueの場合）は繰り返す。
        } while (isIllegalDate(inputDateString));

        System.out.println("入力した日付は正しい内容です。");
    }

    /**
     * 指定された日付の内容が不正であるかをチェック
     * 
     * @param inputDateString 入力された日付の文字列
     * @return true:不正な日付である場合、false:正しい日付である場合
     */
    private static boolean isIllegalDate(String inputDateString) {
        // 日付の形式を指定して、オブジェクトを生成する。
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

        // 厳密な日付チェックを行うように設定する。
        sdf.setLenient(false);

        try {
            // 文字列型の日付情報を基に、
            // Date型の日付情報を生成（このとき日付チェックが行なわれる）
            sdf.parse(inputDateString);

            // 正常に日付情報が生成されたら（正しい日付だったら）、
            // falseを返す。
            return false;
        } catch (ParseException e) {
            // 日付情報の生成に失敗したら
            // （存在しない日付だったら、または日付の形式があやまっていたら）、
            // trueを返す。
            return true;
        }
    }
}
