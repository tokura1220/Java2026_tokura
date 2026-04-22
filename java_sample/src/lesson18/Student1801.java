package lesson18;

/**
 * 学生クラス
 */
public class Student1801 {
	/** 学生の人数（static変数） */
	public static int sum = 0;

	/** 学生番号（インスタンス変数） */
	private int no;

	/** 名前（インスタンス変数） */
	private String name;

	/** 性別（インスタンス変数） */
	private String gender;

	/** 年齢（インスタンス変数） */
	private int age;

	/**
	 * コンストラクタ
	 *
	 * @param no 学生番号
	 * @param name 名前
	 * @param gender 性別
	 * @param age 年齢
	 */
	public Student1801(int no, String name, String gender, int age) {
		this.no = no;
		this.name = name;
		this.gender = gender;
		this.age = age;

		// static変数sumの値を1加算する
		sum++;

		System.out.println("学生を作成しました。");
	}

	/**
	 * 学生個人の情報を出力（インスタンスメソッド）
	 */
	public void show() {
		System.out.println("学生番号は" + no + "番です。");
		System.out.println("氏名は" + name + "です。");
		System.out.println("性別は" + gender + "です。");
		System.out.println("年齢は" + age + "歳です。");
	}

	/**
	 * 学生の人数を出力（staticメソッド）
	 */
	public static void showSum() {
		System.out.println("学生は合計" + sum + "人です。");
	}
}
