package lesson26;

import java.util.ArrayList;
import java.util.List;

public class Sample2601 {
    public static void main(String[] args) {
        // ArrayListの生成
        List<Integer> list = new ArrayList<>();

        // 要素の追加
        list.add(1);
        list.add(3);
        list.add(5);

        // 要素の取得
        System.out.println("数値は" + list.get(0) + "です。");
    }
}
