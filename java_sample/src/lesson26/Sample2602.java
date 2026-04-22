package lesson26;

import java.util.ArrayList;
import java.util.List;

public class Sample2602 {
    public static void main(String[] args) {
        // ArrayListの生成
        List<Integer> list = new ArrayList<>();

        // 要素の追加
        list.add(45);
        list.add(80);
        list.add(76);
        list.add(56);
        list.add(55);

        // 1回の繰り返しごとに、要素の値が変数valueに代入される
        for (int value : list) {
            System.out.println(value);
        }
    }
}
