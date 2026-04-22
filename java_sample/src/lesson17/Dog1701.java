package lesson17;

/**
 * 犬クラス
 */
public class Dog1701 {
	/** 性別 */
	private String gender;
	/** 犬種 */
	private String breed;

	/**
	 * コンストラクタ
	 *
	 * @param gender 性別
	 * @param breed 犬種
	 */
	public Dog1701(String gender, String breed) {
		this.gender = gender;
		this.breed = breed;

		System.out.println("犬を作成しました。");
	}

	/**
	 * 性別と犬種の値を出力
	 */
	public void show() {
		System.out.println("性別は" + gender + "です。");
		System.out.println("犬種は" + breed + "です。");
	}
}
