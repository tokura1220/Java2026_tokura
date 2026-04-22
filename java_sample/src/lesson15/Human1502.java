package lesson15;

/**
 * 人間クラス
 */
public class Human1502 {
    /** 名前 */
    private String name;

    /** 性別 */
    private String gender;

    /**
     * 名前を取得（nameフィールドのgetter）
     *
     * @return 名前
     */
    public String getName() {
        return name;
    }

    /**
     * 性別を取得（genderフィールドのgetter）
     *
     * @return 性別
     */
    public String getGender() {
        return gender;
    }

    /**
     * 名前を設定（nameフィールドのsetter）
     *
     * @param name 名前
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 性別を設定（genderフィールドのsetter）
     *
     * @param gender 性別
     */
    public void setGender(String gender) {
        this.gender = gender;
    }
}
