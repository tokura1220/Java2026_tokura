package lesson16;

/**
 * 人間クラス
 */
public class Human1601 {
    /** 名前 */
    private String name;

    /** 年齢 */
    private int age;

    /**
     * プロフィールを設定
     *
     * @param name 名前
     */
    public void setProfile(String name) {
        this.name = name;
        System.out.println("名前を" + this.name + "にしました。");
    }

    /**
     * プロフィールを設定
     *
     * @param age 年齢
     */
    public void setProfile(int age) {
        this.age = age;
        System.out.println("年齢を" + this.age + "歳にしました。");
    }

    /**
     * プロフィールを設定
     *
     * @param name 名前
     * @param age 年齢
     */
    public void setProfile(String name, int age) {
        this.name = name;
        this.age = age;
        System.out.println("名前を" + this.name + "に、年齢を" + this.age + "歳にしました。");
    }

}
