package kakunin05.question13;

/**
 * staticメンバ
 */
public class Student {

	// 既存コード
	private int num;
	private String name;

	public Student() {
		this(-1, "なし");
	}
	
	public Student(int num, String name) {
		this.num = num;
		this.name = name;
		System.out.print("【入学希望者】");
		showStudent();
	}
	private void showStudent() {
		System.out.printf("番号:%d 名前:%s\r\n", num, name);
	}
	
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

}
