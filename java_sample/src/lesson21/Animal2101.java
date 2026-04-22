package lesson21;

/**
 * 動物クラス（抽象クラス）
 */
public abstract class Animal2101 {
    /** 鳴くメソッド（抽象メソッド） */
    abstract void bark();

    /** 挨拶メソッド（具象メソッド） */
    public void greet() {
        System.out.println("よろしくお願いします。");
    }
}
