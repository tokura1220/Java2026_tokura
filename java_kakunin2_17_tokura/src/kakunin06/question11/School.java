package kakunin06.question11;

/**
 * オーバーロード
 */
public class School {

	// 既存コード
	private Student[] students = new Student[3];
	private int lastIdx = 0;

	public void setStudent(int num, String name) {
		Student s = new Student();
		s.setNum(num);
		s.setName(name);
		if (lastIdx < students.length) {
			students[lastIdx] = s;
			System.out.printf("席%dに登録しました。\r\n", lastIdx + 1);
			showStudent(lastIdx);
			lastIdx++;
		}
	}
	private void showStudent(int index) {
		Student s = students[index];
		System.out.printf("席%d 番号:%d 名前:%s\r\n", index + 1, s.getNum(), s.getName());
	}
	
	// 2
	public Student getStudentBySeat(int seatNum) {
		return students[seatNum-1];
	}
	public void showStudent(Student s) {
		System.out.println("番号:" + s.getNum() + " 名前:" +s.getName());
	}
	

	// 3
	public void showStudent() {
		System.out.println("---学生リスト---");
	
		for (int i=0; i<students.length;i++) {
			showStudent(students[i]);
		}
	}

}
