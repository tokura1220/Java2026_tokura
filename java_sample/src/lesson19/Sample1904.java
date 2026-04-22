package lesson19;

import java.math.BigDecimal;

public class Sample1904 {
    public static void main(String[] args) {
        double d = 1.0000000000000001;

        // 丸め誤差が発生した結果が出力される
        System.out.println(d);

        // 正確に小数点以下の数値が出力される
        BigDecimal bd = new BigDecimal("1.0000000000000001");
        System.out.println(bd);
    }
}
