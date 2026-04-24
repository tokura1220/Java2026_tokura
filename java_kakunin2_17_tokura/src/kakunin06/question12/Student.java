package kakunin06.question12;

/**
 * コンストラクタ
 */
public class Student {

	// 既存コード
	private int num;
	private String name;
	
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

	// 2
	public Student () {
		this(-1,"なし");
		
	}
	public Student(int num,String name) {
		this.num = num;
		this.name =name;
		
		System.out.print("【入学希望者】");
		showStudent();
	}
	private void showStudent() {
		System.out.println("番号:" + num + " 名前:" + name);
	}

}
