package kakunin05.question11;

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

	// 3

}
