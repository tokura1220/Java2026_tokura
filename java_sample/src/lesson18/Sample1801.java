package lesson18;

public class Sample1801 {
    public static void main(String[] args) {
        // staticメソッドを呼び出す
        Student1801.showSum();

        // 学生クラスのオブジェクトを生成
        Student1801 student1 = new Student1801(1, "まなみ", "女", 19);

        // staticメソッドを呼び出す
        Student1801.showSum();

        // 学生クラスのオブジェクトを生成
        Student1801 student2 = new Student1801(2, "けんた", "男", 22);

        // staticメソッドを呼び出す
        Student1801.showSum();

        student1.show();
        student2.show();
    }
}
