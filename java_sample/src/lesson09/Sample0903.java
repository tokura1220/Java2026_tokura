package lesson09;

public class Sample0903 {
    public static void main(String[] args) {
        int[] height = { 162, 177, 154, 185 };

        for (int i = 0; i < height.length; i++) {
            System.out.println((i + 1) + "人目の身長は" + height[i] + "です。");
        }
    }
}
