package lesson23;

/**
 * 職業人クラス
 */
public abstract class Worker2301 {
    /** 職業 */
    protected String job;

    /** 名前 */
    protected String name;

    /** 年齢 */
    protected int age;

    /**
     * 職業人を設定
     *
     * @param job 職業
     * @param name 名前
     * @param age 年齢
     */
    protected Worker2301(String job, String name, int age) {
        this.job = job;
        this.name = name;
        this.age = age;
    }

    /**
     * 自己紹介を表示
     */
    public void showIntroduction() {
        System.out.println("名前は" + name + "、年齢は" + age + "歳、職業は" + job + "です。");
    }

    /**
     * 仕事内容を表示
     */
    public abstract void doWork();

    /**
     * 職業を取得
     *
     * @return 職業
     */
    public String getJob() {
        return job;
    }

    /**
     * 職業を設定
     *
     * @param job 職業
     */
    public void setJob(String job) {
        this.job = job;
    }

    /**
     * 名前を取得
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 名前を設定
     *
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 年齢を取得
     *
     * @return 年齢
     */
    public int getAge() {
        return age;
    }

    /**
     * 年齢を設定
     *
     * @param age 年齢
     */
    public void setAge(int age) {
        this.age = age;
    }

}
