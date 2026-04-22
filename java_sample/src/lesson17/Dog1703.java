package lesson17;

/**
 * 犬クラス
 */
public class Dog1703 {
    /** 性別 */
    private String gender;
    /** 犬種 */
    private String breed;


    /**
     * コンストラクタ（引数なし）
     */
    public Dog1703() {
        gender = "オス";
        System.out.println("引数なしのコンストラクタで犬を作成しました。");
    }

    /**
     * コンストラクタ（引数あり）
     *
* @param breed 犬種
     */
    public Dog1703(String breed) {
        this();
        this.breed = breed;
        System.out.println("引数ありのコンストラクタで犬を作成しました。");
    }

    /**
     * 性別と犬種の値を出力
     */
    public void show() {
        System.out.println("性別は" + gender + "です。");
        System.out.println("犬種は" + breed + "です。");
    }
}

